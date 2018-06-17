/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import classes.Farmacia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class FarmaciaDAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    public FarmaciaDAO() {
        emf = Persistence.createEntityManagerFactory(("PU"));
        em = emf.createEntityManager();
    }
    public void save(Farmacia farmacia){
         em.getTransaction().begin();
        em.persist(farmacia);
        em.getTransaction().commit();
    }
    
     public List<Farmacia> getAll(){
    Query q = em.createNamedQuery("Farmacia.findAll");
    return q.getResultList();
    }
}
