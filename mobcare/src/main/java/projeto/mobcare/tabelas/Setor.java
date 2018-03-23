package projeto.mobcare.tabelas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Setor 
{
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	
	public String getDescricao() 
	{
		return descricao;
	}
	
	public void setDescricao( String descricao ) 
	{
		this.descricao = descricao;
	}
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId( long id ) 
	{
		this.id = id;
	}
}