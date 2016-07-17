package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import br.ufc.security.Cripitografia;

@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO uDAO;

	@Autowired
	private PapelDAO pDAO;

	Cripitografia c = new Cripitografia();

	@RequestMapping("/loginFormulario")
	public String loginFormulario(Model model) {

		List<Papel> papeis = pDAO.listar();
		model.addAttribute("papel", papeis);

		return "login_formulario";
	}

	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session, Papel papel) {
		Usuario candidato = uDAO.recuperarUsuario(usuario.getLogin());
		String senhaC = c.criptografa(usuario.getSenha());

		// Long idLeitor = uDAO.recuperarPapel(papel.getPapel());
		// Papel p1 = pDAO.recuperarPapel(idLeitor);s

		// System.out.println(papel.getId());
		if (usuario.getLogin().equals("") || candidato == null) {
			return "redirect:loginFormulario";
		}

		List<Papel> meus = candidato.getPapelList();

		for (Papel papel2 : meus) {
			if (papel2.getId() == papel.getId()) {
				if (candidato != null) {
					if (candidato.getSenha().equals(senhaC)
							&& papel.getId() == 1) {
						session.setAttribute("papel", papel);
						session.setAttribute("usuario_leitor", candidato);
						return "menu_leitor";
					} else if (candidato.getSenha().equals(senhaC)
							&& papel.getId() == 2) {
						session.setAttribute("papel", papel);
						session.setAttribute("usuario_jornalista", candidato);
						return "menu_jornalista";
					} else if (candidato.getSenha().equals(senhaC)
							&& papel.getId() == 3) {
						session.setAttribute("papel", papel);
						session.setAttribute("usuario_editor", candidato);
						return "menu_editor";
					}
				}
			}
		}
		return "redirect:loginFormulario";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginFormulario";
	}

	@RequestMapping("/menuLeitor")
	public String menuLeitor() {
		return "menu_leitor";
	}

	@RequestMapping("/menuJornalista")
	public String menuJornalista() {
		return "menu_jornalista";
	}

	@RequestMapping("/menuEditor")
	public String menuEditor() {
		return "menu_editor";
	}

}
