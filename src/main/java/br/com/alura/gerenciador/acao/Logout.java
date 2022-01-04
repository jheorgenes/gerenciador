package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		//sessao.removeAttribute("usuarioLogado"); //Removendo o atributo que define que o usu�rio est� logado
		sessao.invalidate(); //Remove o objeto HttpSession e todos os objetos associados e tamb�m remove o cookies
		return "redirect:entrada?acao=LoginForm";
	}

}
