package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/novaEmpresa") //Define que a classe � um Servlet e j� define tamb�m qual � a rota a ser seguida
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Service � um m�todo sobrescrito que cria o objeto de requisi��o e cria o objeto de resposta para a requisi��o
	 * 
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		/* Lendo os parametros */
		String nomeEmpresa = request.getParameter("nome"); //buscando no html o input do name 'nome' e atribu�ndo a vari�vel (sempre captura string)
		String paramDataEmpresa = request.getParameter("data"); //buscando no html o input do name data e atribu�ndo a vari�vel (sempre captura string)
		Date dataAbertura = null; //Criando uma instancia nula do tipo Date (object) 
		
		/* Fazendo o parse ou convers�o */
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Definindo uma inst�ncia de formata��o de data (recebendo o padr�o de formata��o definido)
			dataAbertura = sdf.parse(paramDataEmpresa); //Adiciona na inst�ncia a vari�vel que cont�m a String da data e depois atribui para um objeto do tipo Date
		} catch (ParseException e) { //Para utilizar o m�todo parse, � necess�rio adicionar um try/catch
			throw new ServletException(e); //Relan�ando a exception ServletException caso falhar, fazendo a inje��o da exception original para n�o perd�-la.
		}
		
		/* Populando os objetos */
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa); //Inserindo o nome da empresa
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa); //Adicionando a empresa cadastrada no banco simulado (uma lista de empresas)
		
//		PrintWriter out = response.getWriter(); //Criando o objeto de resposta utilizando o m�todo getWriter para pegar arquivo em texto ao inv�s de bin�rio
//		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>"); //Imprimindo
				
		response.sendRedirect("listaEmpresas");
		
//		//Chamar o JPS
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //Chama o JSP atrav�s do dispachador apontando o diret�rio
//		request.setAttribute("empresa", empresa.getNome()); //Usa a requisi��o para pendurar um nome para o objeto empresa para ser enviado na requisi��o.
//		rd.forward(request, response); //Envia a requisi��o e a resposta
	}

}
