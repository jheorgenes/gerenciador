package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/entrada") //Anotação WebFilter funciona igual WebServlet (também é pra definir a rota ou mapeamento)
public class MonitoramentoFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis(); //Devolve o tempo de execução em millisegundos
		
		String acao = request.getParameter("acao");
		
		/**
		 * chain significa cadeia (Ele é uma porta de acesso as requisições e saídas, ou seja, está no meio termo, primeiro faz a requisição, depois passa o chain e depois faz o response)
		 * Se não chamado o método doFilter a requisição fica parada. Ao executar doFilter passando request e response, as requisições prossegue o fluxo normal
		 */
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de Execução da ação " + acao + " -> " + (depois - antes));
	}
}
