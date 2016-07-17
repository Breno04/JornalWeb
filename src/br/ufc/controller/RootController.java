package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Noticia;

@Controller
public class RootController {

	@Autowired
	@Qualifier(value = "noticiaDAO")
	private NoticiaDAO nDAO;

	@Autowired
	private ClassificadoDAO cDAO;

	@RequestMapping("/")
	public String home(Model model, Model model2, Model model3) {

		/* Notícias recentes */

		List<Noticia> noticiasDes = this.nDAO.destaques();

		List<Noticia> destaques = new ArrayList<Noticia>();
		destaques.add(noticiasDes.get(0));
		model.addAttribute("destaques", destaques);

		List<Noticia> recentes = new ArrayList<Noticia>();

		int tam = noticiasDes.size();
		int i, j;
		if (tam > 3) {
			for (i = 1; i < 3; i++) {
				recentes.add(noticiasDes.get(i));
			}
		} else {
			for (j = 1; j < tam; j++) {
				recentes.add(noticiasDes.get(j));
			}
		}

		model.addAttribute("recentes", recentes);

		/* -------------------------- Classificados recentes -------------------------- */

		List<Classificado> classifiados = this.cDAO
				.classificadosRecentes();

		List<Classificado> claRecentes = new ArrayList<Classificado>();
		int tamanho = classifiados.size();
		int k, l;
		if (tamanho > 3) {
			for (k = 0; k < 3; k++) {
				claRecentes.add(classifiados.get(k));
			}
		} else {
			for (l = 0; l < tamanho; l++) {
				claRecentes.add(classifiados.get(l));
			}
		}
		
		model3.addAttribute("claRecentes", claRecentes);

		return "home";
	}

}
