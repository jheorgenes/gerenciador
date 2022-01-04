package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.alura.gerenciador.acao.Acao;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao"); //Buscando o parametro na URL cujo o nome seja acao
		
//		/* Definido autentica��o por login */
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm")); //Verificando todas as p�ginas que n�o for p�ginas de login (retorna verdadeiro para var ehUmaAcaoProtegida)
//		
//		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return; //Sa�ndo da execu��o se o usu�rio n�o estiver logado.
//		}

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome;
		
		/**
		 * Try Catch criado para realizar uma inst�ncia gen�rica das classes
		 * � utilizado o objeto Class buscando atrav�s do forName m�todo, o diret�rio e nome da classe completo atrav�s da string definida como nomeDaClasse
		 * A inst�ncia � realida atrav�s do m�todo newInstance() e naturalmente devolve um objeto do tipo Object (gen�rico
		 * Foi necess�rio fazer um cast desse objeto para retornar a inst�ncia para uma Interface que cont�m a assinatura do m�todo acao.
		 * Assim foi poss�vel fazer a execu��o do m�todo executa que recebe como parametro, a requisi��o e a resposta
		 * */
		try {
			Class classe = Class.forName(nomeDaClasse); 
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String tipoEEndereco[] = nome.split(":"); //Separando o nome pelo caractere de separa��o ":" e retorna um array
		
		if(tipoEEndereco[0].equals("forward")) { //Se a primeira parte do array for uma palavra chamada forward, fa�a
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]); //Dispara a requisi��o recebendo como parametro uma String contendo o diret�rio das views com o restante da string definida no retorno dos controllers (usando o segundo elemento do array que � a string)
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		/** Programa��o procedural */
//		String nome = null; //Nome ser� transitado entre a camada de Controller e a camada do Servlet
//		if(paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("RemoveEmpresa")) {	
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);	
//		} else if(paramAcao.equals("MostraEmpresa")) {	
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("AlteraEmpresa")) {	
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
	}
}
