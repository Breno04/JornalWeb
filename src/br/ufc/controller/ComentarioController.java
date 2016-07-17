package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ComentarioController {
	
	@Autowired
	private NoticiaDAO nDAO;
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private ComentarioDAO cDAO;

	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(){
		return "comentario/inserir_comentario_formulario";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(Comentario comentario, Long idNoticia, Long idUsu){
		Noticia n = nDAO.recuperarNoticia(idNoticia);
		Usuario u = uDAO.recuperarUsuario(idUsu);
		
		comentario.setUsuario(u);
		comentario.setNoticia(n);
		
		cDAO.inserirComentario(comentario);
		
		return "redirect:mostrarNoticia?idNoticia=" + idNoticia;
	}
	
	@RequestMapping("/listarComentario")
	public String listarComentario(Model model, Long idNoticia){
		List<Comentario> comentarios = this.cDAO.listarComentario(idNoticia);
		model.addAttribute("comentario", comentarios);
		return "redirect:mostrarNoticia";
		
	}
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long idComentario, Long idNot){
		Comentario c = this.cDAO.recuperarComentario(idComentario);
		c.setAtivo(false);
		
		cDAO.alterarComentario(c);
		
		return "redirect:mostrarNoticia?idNoticia=" + idNot;
	}
}
