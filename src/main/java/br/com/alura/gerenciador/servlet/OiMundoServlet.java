package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/oi") //Anota��o para definir rota
public class OiMundoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OiMundoServlet() {
		System.out.println("Criando OI Mundo Servlet");
	}
	
	/**
	 * M�todo service � utilizado para obter objetos de requisi��es e retornar objetos de resposta
	 * � um servi�o e normalmente precisar� lan�ar excess�es, mas ser�o adicionados quando for chamado classes que obrigam a sua implementa��o (on-checked) 
	 * */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/*Pode ser definido arquivos bin�rios ou textuais*/
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("oi mundo, parab�ns vc escreveu o primeiro servlets.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet OiMundoServlet foi chamado"); //Imprime no console
	}
}
