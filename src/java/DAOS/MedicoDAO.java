/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import classes.Medico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class MedicoDAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    public MedicoDAO() {
        emf = Persistence.createEntityManagerFactory(("PU"));
        em = emf.createEntityManager();
    }
    
     public void save(Medico medico){
         em.getTransaction().begin();
        em.persist(medico);
        em.getTransaction().commit();
     }
    public List<Medico> getAll(){
    Query q = em.createNamedQuery("Medicamento.findAll");
    return q.getResultList();
    }
    
    
}
