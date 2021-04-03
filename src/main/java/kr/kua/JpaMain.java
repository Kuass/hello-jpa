package kr.kua;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // Member member = em.find(Member.class, 1L);
            List<Member> result = em.createQuery("SELECT m FROM Member AS m", Member.class)
                    .setMaxResults(2)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}
