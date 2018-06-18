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
    Query q = em.createNamedQuery("Medico.findAll");
    return q.getResultList();
    }
    
     public Medico checkaLogin(String login, String password){
        if(login != "" || password != ""){
             Query q = em.createNamedQuery("Medico.findByNome").setParameter("nome", login);
             Query q2= em.createNamedQuery("Medico.findBySenha").setParameter("senha", password);
             
             if(q.getResultList().size() > 0 && q2.getResultList().size() > 0){
                 return (Medico) q.getSingleResult();
             }else{
                 return null;
             }
        }
        return null;
    }
    
}
