/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import classes.Medicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class MedicamentoDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public MedicamentoDAO() {
        emf = Persistence.createEntityManagerFactory(("PU"));
        em = emf.createEntityManager();
    }

    public void save(Medicamento medicamento) {
        em.getTransaction().begin();
        em.persist(medicamento);
        em.getTransaction().commit();
    }

    public List<Medicamento> getAll() {
        Query q = em.createNamedQuery("Medicamento.findAll");
        return q.getResultList();
    }
    public Medicamento findByName(String nome){
          Query q = em.createNamedQuery("Medicamento.findByNome");
          q.setParameter("nome", nome);
        return (Medicamento) q.getSingleResult();
    }
}
