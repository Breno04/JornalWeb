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

import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;
import br.ufc.util.FileUtil;

@Transactional
@Controller
public class NoticiaController {

	@Autowired
	@Qualifier(value = "noticiaDAO")
	private NoticiaDAO nDAO;

	@Autowired
	private UsuarioDAO uDAO;

	@Autowired
	private SecaoDAO sDAO;

	@Autowired
	private ComentarioDAO cDAO;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/cadastrarNoticiaFormulario")
	public String cadastrarNoticiaFormulario(Model model) {

		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secao", secoes);

		return "noticia/cadastrar_noticia_formulario";
	}

	@RequestMapping("/cadastrarNoticia")
	public String cadastrarNoticia(
			Noticia noticia,
			Long secao_id,
			Long usuario_id,
			@RequestParam(value = "imagem", required = false) MultipartFile imagem) {

		String path = servletContext.getRealPath("/") + "resources/imagem/"
				+ noticia.getTitulo() + ".png";

		FileUtil.salvarImagem(path, imagem);

		Usuario u = this.uDAO.recuperarUsuario(usuario_id);
		Secao s = this.sDAO.recuperarSecao(secao_id);
		noticia.setUsuario(u);
		noticia.setSecao(s);

		nDAO.inserirNoticia(noticia);
		return "redirect:mostrarMancheteNoticia?idSecao="+secao_id;
	}

	@RequestMapping("/mostrarMancheteNoticia")
	public String mostrarMancheteNoticia(Model model, Long idSecao) {
		List<Noticia> noticias = this.nDAO.mostrarManchete(idSecao);
		model.addAttribute("noticia", noticias);

		return "noticia/mostrar_manchetes";
	}

	@RequestMapping("/mostrarNoticia")
	public String mostrarNoticia(Model model, Long idNoticia) {
		List<Noticia> noticias = this.nDAO.mostrarNoticia(idNoticia);
		model.addAttribute("noticia", noticias);

		List<Comentario> comentarios = this.cDAO.listarComentario(idNoticia);
		model.addAttribute("comentario", comentarios);
		return "noticia/mostrar_noticia";
	}

	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long idNoticia) {
		Noticia n = this.nDAO.recuperarNoticia(idNoticia);
		n.setAtivo(false);

		this.nDAO.alterarNoticia(n);

		return "redirect:listarSecao";
	}

	@RequestMapping("/mostrarNoticiaJornalista")
	public String mostrarNoticiaJornalista(Long usuarioId, Model model) {
		List<Noticia> noticias1 = this.nDAO.mostrarNoticiaJornalista(usuarioId);
		model.addAttribute("noticias1", noticias1);

		return "noticia/mostrar_noticia_jornalista";
	}

	@RequestMapping("/mostrarMancheteRecente")
	public String mostrarMancheteRecente(Model model) {
		List<Noticia> noticiasDes = this.nDAO.destaques();

		model.addAttribute("destaques", noticiasDes);

		return "home";
	}

}