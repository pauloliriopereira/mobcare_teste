package projeto.mobcare.dao;

import projeto.mobcare.tabelas.Colaborador;

public interface Dao 
{
	public Object buscar( String cpf );
	public void inserir( Object objeto );
	public void remover( String cpf );
}