/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import classes.Receita;
import classes.Receitaxexame;
import classes.Receitaxmedicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class ReceitaDAO {

    private EntityManager em;
    private EntityManagerFactory emf;

    public ReceitaDAO() {
        emf = Persistence.createEntityManagerFactory(("PU"));
        em = emf.createEntityManager();
    }

    public void save(Receita receita) {
        em.getTransaction().begin();
        em.persist(receita);
        em.getTransaction().commit();
    }

    public List<Receita> getAll() {
        Query q = em.createNamedQuery("Receita.findAll");
        return q.getResultList();
    }
    
    public void saveMedicamentos(Receitaxmedicamento rxm) {
        em.getTransaction().begin();
        em.persist(rxm);
        em.getTransaction().commit();
    }
      public void saveExames(Receitaxexame rxe) {
        em.getTransaction().begin();
        em.persist(rxe);
        em.getTransaction().commit();
    }
}
