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
		
//		/* Definido autenticação por login */
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm")); //Verificando todas as páginas que não for páginas de login (retorna verdadeiro para var ehUmaAcaoProtegida)
//		
//		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return; //Saíndo da execução se o usuário não estiver logado.
//		}

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome;
		
		/**
		 * Try Catch criado para realizar uma instância genérica das classes
		 * É utilizado o objeto Class buscando através do forName método, o diretório e nome da classe completo através da string definida como nomeDaClasse
		 * A instância é realida através do método newInstance() e naturalmente devolve um objeto do tipo Object (genérico
		 * Foi necessário fazer um cast desse objeto para retornar a instância para uma Interface que contém a assinatura do método acao.
		 * Assim foi possível fazer a execução do método executa que recebe como parametro, a requisição e a resposta
		 * */
		try {
			Class classe = Class.forName(nomeDaClasse); 
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String tipoEEndereco[] = nome.split(":"); //Separando o nome pelo caractere de separação ":" e retorna um array
		
		if(tipoEEndereco[0].equals("forward")) { //Se a primeira parte do array for uma palavra chamada forward, faça
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]); //Dispara a requisição recebendo como parametro uma String contendo o diretório das views com o restante da string definida no retorno dos controllers (usando o segundo elemento do array que é a string)
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		/** Programação procedural */
//		String nome = null; //Nome será transitado entre a camada de Controller e a camada do Servlet
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
