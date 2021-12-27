package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>(); //atributo criado para simular um banco de dados, por isso ser� static
	private static Integer chaveSequencial = 1;
	
	//O static declarado aqui em cima possibilita que assim que a classe for chamada, ser� executado esse bloco automaticamente
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	/**
	 * M�todo para adicionar uma empresa em uma lista (simulando um banco de dados)
	 * */
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa); //Chama o nome da pr�pria classe antes de chamar o atributo, j� que o atributo foi definido como statico.
	}
	
	/**
	 * M�todo para listar todas as empresas cadastradas
	 * @return lista de empresas cadastradas
	 * */
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		//Para n�o ocorrer erro ao remover todos os elementos da lista usando foreach, � necess�rio realizar o la�o abaixo que consegue iterar corretamente para remo��o.
		Iterator<Empresa> it = Banco.lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id){
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
}
