package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/oi") //Anotação para definir rota
public class OiMundoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OiMundoServlet() {
		System.out.println("Criando OI Mundo Servlet");
	}
	
	/**
	 * Método service é utilizado para obter objetos de requisições e retornar objetos de resposta
	 * É um serviço e normalmente precisará lançar excessões, mas serão adicionados quando for chamado classes que obrigam a sua implementação (on-checked) 
	 * */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/*Pode ser definido arquivos binários ou textuais*/
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("oi mundo, parabéns vc escreveu o primeiro servlets.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet OiMundoServlet foi chamado"); //Imprime no console
	}
}
