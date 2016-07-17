package br.ufc.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@RequestMapping("/cadastrarSecaoFormulario")
	public String cadastrarSecaoFormulario(){
		return "secao/cadastrar_secao_formulario";
	}
	
	@RequestMapping("/cadastrarSecao")
	public String cadastrarSecao(Secao secao){
		sDAO.inserir(secao);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("/listarSecao")
	public String listarUsuario(Model model){
		
		List<Secao> secao = this.sDAO.listar();
		model.addAttribute("secoes", secao);
		 	
		return "secao/lista_secao";
	}

}
