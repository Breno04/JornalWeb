package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	private UsuarioDAO uDAO;

	@Autowired
	private ClassificadoDAO clDAO;

	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario() {
		return "classificado/inserir_classificado_formulario";
	}

	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(Classificado classificado, Long usuId) {
		Usuario u = this.uDAO.recuperarUsuario(usuId);
		classificado.setUsuario(u);
		this.clDAO.inserirClassificado(classificado);

		return "redirect:mostrarMancheteClassificado";
	}

	@RequestMapping("/mostrarMancheteClassificado")
	public String mostrarMancheteClassificado(Model model) {
		List<Classificado> classificados = this.clDAO
				.mostrarMancheteClassificado();
		model.addAttribute("classificado", classificados);

		return "classificado/mostrar_manchete_classificado";
	}

	@RequestMapping("/mostrarClassificado")
	public String mostrarClassificado(Model model, Long claId) {
		List<Classificado> classificados = this.clDAO
				.mostrarClassificado(claId);
		model.addAttribute("classificado1", classificados);

		return "classificado/mostrar_classificado";

	}

	@RequestMapping("/inserirOferta")
	public String inserirOferta(Long idUsuario, Long idClassificado,
			Double melhorOferta) {

		Classificado classificado = this.clDAO
				.recuperarClassificado(idClassificado);

		if (classificado.getPrecoInicial() < melhorOferta && classificado.getMelhorOferta() < melhorOferta) {
			Usuario u = this.uDAO.recuperarUsuario(idUsuario);

			classificado.setAutorOferta(u.getUsuarioId());
			classificado.setNomeAutorOferta(u.getNomeCompleto());
			classificado.setMelhorOferta(melhorOferta);

			this.clDAO.alterarClassificado(classificado);

			return "redirect:mostrarClassificado?claId=" + idClassificado;
		} else {
			return "redirect:mostrarClassificado?claId=" + idClassificado;
		}
	}
	
	@RequestMapping("/mostrarClassificadoRecente")
	public String mostrarClassificadoRecente(Model model){
		List<Classificado> classificados = this.clDAO.classificadosRecentes();
		
		model.addAttribute("claRecentes", classificados);
		
		return "home";
	}
}
