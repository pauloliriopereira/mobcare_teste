package projeto.mobcare.tabelas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table( name="colaborador" )
@XmlRootElement
@NamedQueries({
	@NamedQuery( name="colaborador.buscaPorCpf", 
			     query="select c from Colaborador c where c.cpf = :cpf" )
})
public class Colaborador 
{
	@Id
	@GeneratedValue
	private long id;
	
	@Column( length=11, nullable=false, unique=true )
	private String cpf;
	private String nome;
	private String telefone; 
	private String email;
	
	@OneToOne
	@JoinColumn ( name="colaborador_id" )
	private Setor setor;
	
	public Setor getSetor() 
	{
		return setor;
	}

	public void setSetor( Setor setor ) 
	{
		this.setor = setor;
	}

	public String getCpf() 
	{
		return cpf;
	}
	
	public void setCpf( String cpf )
	{
		this.cpf = cpf;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome( String nome )
	{
		this.nome = nome;
	}
	
	public String getTelefone()
	{
		return telefone;
	}
	
	public void setTelefone( String telefone ) 
	{
		this.telefone = telefone;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail( String email ) 
	{
		this.email = email;
	}
	
	public long getId() 
	{
		return id;
	}
}