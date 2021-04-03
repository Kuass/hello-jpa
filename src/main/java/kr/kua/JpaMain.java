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
            Member findMember = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

                    System.out.println("result : " + (findMember == findMember2));

            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}
