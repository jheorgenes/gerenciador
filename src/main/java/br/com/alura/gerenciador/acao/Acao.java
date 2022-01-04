package br.com.alura.gerenciador.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; //método publico e abstrato automaticamente, por conta de ser uma interface
}
