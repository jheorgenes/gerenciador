package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/entrada") //Anota��o WebFilter funciona igual WebServlet (tamb�m � pra definir a rota ou mapeamento)
public class MonitoramentoFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis(); //Devolve o tempo de execu��o em millisegundos
		
		String acao = request.getParameter("acao");
		
		/**
		 * chain significa cadeia (Ele � uma porta de acesso as requisi��es e sa�das, ou seja, est� no meio termo, primeiro faz a requisi��o, depois passa o chain e depois faz o response)
		 * Se n�o chamado o m�todo doFilter a requisi��o fica parada. Ao executar doFilter passando request e response, as requisi��es prossegue o fluxo normal
		 */
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de Execu��o da a��o " + acao + " -> " + (depois - antes));
	}
}
