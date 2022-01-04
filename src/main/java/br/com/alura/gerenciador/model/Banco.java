package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>(); //atributo criado para simular um banco de dados, por isso será static
	private static Integer chaveSequencial = 1;
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	//O static declarado aqui em cima possibilita que assim que a classe for chamada, será executado esse bloco automaticamente
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("Jheorgenes");
		u1.setSenha("123456");
		
		Usuario u2 = new Usuario();
		u2.setLogin("nico	");
		u2.setSenha("123456");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}
	
	/**
	 * Método para adicionar uma empresa em uma lista (simulando um banco de dados)
	 * */
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa); //Chama o nome da própria classe antes de chamar o atributo, já que o atributo foi definido como statico.
	}
	
	/**
	 * Método para listar todas as empresas cadastradas
	 * @return lista de empresas cadastradas
	 * */
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		//Para não ocorrer erro ao remover todos os elementos da lista usando foreach, é necessário realizar o laço abaixo que consegue iterar corretamente para remoção.
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

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
