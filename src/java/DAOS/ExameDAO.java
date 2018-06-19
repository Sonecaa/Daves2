
package DAOS;

import classes.Exame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ExameDAO {
      private EntityManager em;
    private EntityManagerFactory emf;

    public ExameDAO() {
        emf = Persistence.createEntityManagerFactory(("PU"));
        em = emf.createEntityManager();
    }

    public void save(Exame exame) {
        em.getTransaction().begin();
      em.persist(exame);
        
        em.getTransaction().commit();
    }

    public List<Exame> getAll() {
        Query q = em.createNamedQuery("Exame.findAll");
        return q.getResultList();
    }
    public Exame findByName(String nome){
          Query q = em.createNamedQuery("Exame.findByNome");
          q.setParameter("nome", nome);
        return (Exame) q.getSingleResult();
    }
}
