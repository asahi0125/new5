package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserWorker02 {

    @PersistenceContext
    private EntityManager em;

    public void register(UserEntity02 ue) {
        em.persist(ue);
    }

    public List<UserEntity02> getData() {
        return em.createQuery("SELECT r FROM UserEntity02 r").getResultList();
    }
}

