package projeto.mobcare.dao;

public interface Dao 
{
	public Object buscar( String cpf );
	public void inserir( Object objeto );
	public void remover( String cpf );
}