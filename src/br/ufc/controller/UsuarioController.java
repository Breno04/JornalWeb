package br.ufc.controller;

import java.util.List; 

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import br.ufc.security.Cripitografia;
import br.ufc.util.FileUtil;

@Transactional
@Controller
public class UsuarioController {

	@Autowired
	@Qualifier(value = "usuarioDAO")
	private UsuarioDAO uDAO;

	@Autowired
	private PapelDAO pDAO;
	
	@Autowired
	private ServletContext servletContext;

	Cripitografia c = new Cripitografia();

	@RequestMapping("/cadastrarLeitorFormulario")
	public String cadastrarLeitorFormulario() {

		return "usuario/cadastrar_leitor_formulario";
	}

	@RequestMapping("/cadastrarJornalistaFormulario")
	public String cadastrarJornalistaFormulario() {

		return "usuario/cadastrar_jornalista_formulario";
	}

	@RequestMapping("/cadastrarUsuarioLeitor")
	public String cadastrarUsuarioLeitor(Usuario usuario) {

		String senhaCripitografada = c.criptografa(usuario.getSenha());
		usuario.setSenha(senhaCripitografada);

		Long idLeitor = uDAO.recuperarPapel("Leitor");
		Papel papel = pDAO.recuperarPapel(idLeitor);

		this.uDAO.inserirUsuario(usuario, papel);

		return "redirect:loginFormulario";
	}

	@RequestMapping("/cadastrarUsuarioJornalista")
	public String cadastrarUsuarioJornalista(
			Usuario usuario,
			@RequestParam(value = "imagem", required = false) MultipartFile imagem) {
		
		String path = servletContext.getRealPath("/") + "resources/imagem/"
				+ usuario.getLogin() + ".png";
		
		FileUtil.salvarImagem(path, imagem);

		String senhaCripitografada = c.criptografa(usuario.getSenha());
		usuario.setSenha(senhaCripitografada);

		Long idLeitor = uDAO.recuperarPapel("Jornalista");
		Papel papel = pDAO.recuperarPapel(idLeitor);

		this.uDAO.inserirUsuario(usuario, papel);

		return "redirect:loginFormulario";
	}

	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model) {

		List<Usuario> usuario = this.uDAO.listar();
		model.addAttribute("usuarios", usuario);

		return "usuario/listar_usuario";
	}

	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id) {
		Usuario u = this.uDAO.recuperarUsuario(id);
		u.setAtivo(false);

		this.uDAO.alterarUsuario(u);

		return "redirect:listarUsuario";
	}

	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long usuId, Model model) {

		Usuario usuario = this.uDAO.recuperarUsuario(usuId);
		model.addAttribute("usuario", usuario);

		return "usuario/alterar_usuario_formulario";
	}

	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario) {

		this.uDAO.alterarUsuario(usuario);

		return "redirect:listarUsuario";
	}

}
