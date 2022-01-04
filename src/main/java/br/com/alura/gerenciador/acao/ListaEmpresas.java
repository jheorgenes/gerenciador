package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao {
	
	/** 
	 * M�todo executa a a��o, instanciando a camada de Modelo e retorna o Objeto do tipo String
	 * @param HttpServletRequest request
	 * @param HttpServletResponse resposnse
	 * @return listaEmpresas.jsp 
	 * */
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("listando empresa");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista); 
		
		return "forward:listaEmpresas.jsp"; //Devolve um reenvio da requisi��o para o formul�rio listaEmpresas.jsp (forward significa que ele vai reenviar a �ltima requisi��o feita quando voc� pedir para atualizar a p�gina.)
	}
}
