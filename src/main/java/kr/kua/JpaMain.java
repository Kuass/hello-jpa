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
            Member member1 = new Member(150L , "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            tx.commit();
            // 트렌젝션 커밋때 persist 한 Member 객체가 Query 된다.
        }catch(Exception e) {
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}
