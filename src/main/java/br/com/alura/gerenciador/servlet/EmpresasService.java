package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String valor = request.getHeader("Accept"); //na requisição que está chegando, lê o cabeçalho cujo nome é Accept e devolve uma String
		
		System.out.println(valor);
		
		if(valor.contains("xml")) { //Se a string valor conter alguma coisa no seu corpo chamada xml
			XStream xstream = new XStream(); //Importando o XStream biblioteca para ter acesso a esse objeto (import com.thoughtworks.xstream.XStream;)
			xstream.alias("empresa", Empresa.class); //Definindo um alias (um apelido) em formato de tag para a classe empresa.
			String xml = xstream.toXML(empresas);  //Transformando um objeto em XML e retornando para uma string já no formato XML
			
			response.setContentType("application/xml"); 
			response.getWriter().print(xml); 
		} else if(valor.contains("json")) { //Se a string valor conter alguma coisa no seu corpo chamada json
			Gson gson = new Gson(); //Importando o GSON biblioteca para ter acesso a esse objeto
			String json = gson.toJson(empresas);  //Transformando um objeto em Json e retornando para uma string já no formato json
			
			response.setContentType("application/json"); //Explicitando que a aplicação que será devolvida será do tipo JSON
			response.getWriter().print(json); //Devolvendo uma resposta escrita em json
		} else { //Se não for nenhum dos dois, devolve um json contendo uma mensagem de erro.
			response.setContentType("application/json"); 
			response.getWriter().print("{'message':'no content'}"); //Imprimindo uma string qualificada como json
		}
	}
}
