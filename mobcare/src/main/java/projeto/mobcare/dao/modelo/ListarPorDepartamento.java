package projeto.mobcare.dao.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarPorDepartamento
{
	private String nome;
	private String email;
	private String departamento;
	
	public ListarPorDepartamento( String nome, String email, String departamento ) 
	{
		this.nome = nome;
		this.email = email;
		this.departamento = departamento;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome( String nome ) 
	{
		this.nome = nome;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail( String email ) 
	{
		this.email = email;
	}

	public String getDepartamento() 
	{
		return departamento;
	}

	public void setDepartamento( String departamento )
	{
		this.departamento = departamento;
	}
}
