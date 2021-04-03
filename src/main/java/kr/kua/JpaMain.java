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
            // JPA 는 반드시 조회된 객체를 영속성 컨텍스트에 넣어준다.
            // 다음에 영속성 컨텍스트에 1차 캐시에 저장된 곳에서 찾아서 findMember2를 찾는다.

            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}
