package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.model.Papel;
import br.ufc.model.Usuario;

public class Interceptador extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String URI = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute(
				"usuario_leitor");
		Usuario usuario2 = (Usuario) request.getSession().getAttribute(
				"usuario_jornalista");
		Usuario usuario3 = (Usuario) request.getSession().getAttribute(
				"usuario_editor");
		Papel papel = null;

		if (URI.equals("/Jornal_Eletronico/resources/css/estilo.css")
				|| URI.contains("resources/imagem/")) {
			return true;
		}

		if (request.getSession().getAttribute("papel") != null) {
			papel = (Papel) request.getSession().getAttribute("papel");
		}

		if (URI.endsWith("loginFormulario") || URI.endsWith("login")
				|| URI.endsWith("/")
				|| URI.endsWith("cadastrarLeitorFormulario")
				|| URI.endsWith("cadastrarUsuarioLeitor")
				|| URI.endsWith("logout")
				|| URI.endsWith("mostrarMancheteNoticia")
				|| URI.endsWith("mostrarNoticia")
				|| URI.endsWith("listarComentario")
				|| URI.endsWith("mostrarMancheteClassificado")
				|| URI.endsWith("mostrarClassificado")
				|| URI.endsWith("listarSecao")
				|| URI.endsWith("listarUsuario")) {
			return true;
		}

		if (usuario != null || usuario2 != null || usuario3 != null) {
			if ((URI.endsWith("loginFormulario") || URI.endsWith("login")
					|| URI.endsWith("/")
					|| URI.endsWith("mostrarMancheteNoticia") || URI
						.endsWith("mostrarNoticia"))) {
				return true;
			}

			if (papel.getId() == 1) {
				if (URI.endsWith("inserirComentario")
						|| URI.endsWith("apagarComentario")
						|| URI.endsWith("inserirOferta")
						|| URI.endsWith("mostrarMancheteClassificado")
						|| URI.endsWith("mostrarClassificado")) {
					return true;
				}
			} else if (papel.getId() == 2) {
				if (URI.endsWith("cadastrarNoticiaFormulario")
						|| URI.endsWith("cadastrarNoticia")
						|| URI.endsWith("mostrarNoticiaJornalista")
						|| URI.endsWith("apagarNoticia")) {

					return true;
				}
			} else {
				if (URI.endsWith("apagarNoticia")
						|| URI.endsWith("cadastrarJornalistaFormulario")
						|| URI.endsWith("cadastrarUsuarioJornalista")
						|| URI.endsWith("inserirClassificadoFormulario")
						|| URI.endsWith("inserirClassificado")
						|| URI.endsWith("cadastrarSecaoFormulario")
						|| URI.endsWith("cadastrarSecao")) {
					return true;
				}
			}
			if(usuario != null){
				response.sendRedirect("loginFormulario");
				return false;
			} else if(usuario2 != null){
				response.sendRedirect("loginFormulario");
				return false;
			} else {
				response.sendRedirect("loginFormulario");
				return false;
			}
		}
		response.sendRedirect("loginFormulario");
		return false;
	}
}
