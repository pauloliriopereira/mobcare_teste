package projeto.mobcare.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.mobcare.dao.GerenciadorDePersistencia;
import projeto.mobcare.dao.modelo.ListarPorDepartamento;

public class TesteConsulta {

	public static void main(String[] args) 
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		String consulta = "select new projeto.mobcare.dao.modelo.ListarPorDepartamento(c.nome, c.email, c.setor.descricao) from Colaborador c"
				          + " inner join Setor s on c.setor.id = s.id order by s.id desc";
		Query query = manager.createQuery( consulta ) ;
		List<ListarPorDepartamento> lista = query.getResultList();
		
		for (ListarPorDepartamento listarPorDepartamento : lista) 
		{
			System.out.print(listarPorDepartamento.getNome());
			System.out.print(listarPorDepartamento.getEmail());
			System.out.print(listarPorDepartamento.getDepartamento());
			System.out.println();
		}
		manager.close();
		GerenciadorDePersistencia.fechar();
	}
}