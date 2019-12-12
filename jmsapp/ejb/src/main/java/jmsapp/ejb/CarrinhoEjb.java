package jmsapp.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jmsapp.modelo.Produto;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CarrinhoEjb {

	@PersistenceContext(unitName = "jmsapp")
	private EntityManager em;

	public Produto add(Produto produto) {
		em.persist(produto);
		em.flush();
		return produto;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> findAll(Integer clienteId) {
		Query query= em.createQuery("SELECT P FROM Produto P WHERE P.idCli=:cliente");
		query.setParameter("cliente",clienteId);
		System.out.println((List<Produto>)query.getResultList());
		
		return (List<Produto>)query.getResultList();
	}
	
	public Produto findOne(Integer id) {
		return em.find(Produto.class, id);
	}

	public void remove(Integer id) {
		em.remove(this.findOne(id));	
	}

	public void remove(Integer produtoId, Integer clienteId) {
		Query query= em.createQuery("DELETE FROM Produto P WHERE P.idCli=:cliente AND P.id=:produto");
		query.setParameter("cliente",clienteId);
		query.setParameter("produto",produtoId);

		query.executeUpdate();
	}
	

}
