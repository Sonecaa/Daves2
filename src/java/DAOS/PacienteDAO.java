/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import classes.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
}
