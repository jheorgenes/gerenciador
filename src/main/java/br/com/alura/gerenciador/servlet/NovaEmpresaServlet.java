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
//@WebServlet("/novaEmpresa") //Define que a classe é um Servlet e já define também qual é a rota a ser seguida
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Service é um método sobrescrito que cria o objeto de requisição e cria o objeto de resposta para a requisição
	 * 
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		/* Lendo os parametros */
		String nomeEmpresa = request.getParameter("nome"); //buscando no html o input do name 'nome' e atribuíndo a variável (sempre captura string)
		String paramDataEmpresa = request.getParameter("data"); //buscando no html o input do name data e atribuíndo a variável (sempre captura string)
		Date dataAbertura = null; //Criando uma instancia nula do tipo Date (object) 
		
		/* Fazendo o parse ou conversão */
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Definindo uma instância de formatação de data (recebendo o padrão de formatação definido)
			dataAbertura = sdf.parse(paramDataEmpresa); //Adiciona na instância a variável que contém a String da data e depois atribui para um objeto do tipo Date
		} catch (ParseException e) { //Para utilizar o método parse, é necessário adicionar um try/catch
			throw new ServletException(e); //Relançando a exception ServletException caso falhar, fazendo a injeção da exception original para não perdê-la.
		}
		
		/* Populando os objetos */
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa); //Inserindo o nome da empresa
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa); //Adicionando a empresa cadastrada no banco simulado (uma lista de empresas)
		
//		PrintWriter out = response.getWriter(); //Criando o objeto de resposta utilizando o método getWriter para pegar arquivo em texto ao invés de binário
//		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>"); //Imprimindo
				
		response.sendRedirect("listaEmpresas");
		
//		//Chamar o JPS
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //Chama o JSP através do dispachador apontando o diretório
//		request.setAttribute("empresa", empresa.getNome()); //Usa a requisição para pendurar um nome para o objeto empresa para ser enviado na requisição.
//		rd.forward(request, response); //Envia a requisição e a resposta
	}

}
