/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import classes.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class PacienteDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public PacienteDAO() {
        emf = Persistence.createEntityManagerFactory(("PU"));
        em = emf.createEntityManager();
    }
    public void save(Paciente paciente){
        em.getTransaction().begin();
        em.persist(paciente);
        em.getTransaction().commit();
    }
    public List<Paciente> getAll(){
    Query q = em.createNamedQuery("Paciente.findAll");
    return q.getResultList();
    }
    
    public Paciente checkaLogin(String login, String password){
        if(login != "" || password != ""){
             Query q = em.createNamedQuery("Paciente.findByNome").setParameter("nome", login);
             Query q2= em.createNamedQuery("Paciente.findBySenha").setParameter("senha", password);
             
             if(q.getResultList().size() > 0 && q2.getResultList().size() > 0){
                 return (Paciente) q.getSingleResult();
             }else{
                 return null;
             }
        }
        return null;
    }
    
}
