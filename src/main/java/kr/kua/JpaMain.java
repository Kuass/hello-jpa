package kr.kua;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            List<Member> result = em.createQuery(
                    "select m from Member m where m.username like '%kim%'",
                    Member.class
            ).getResultList();
            // from "Member m" where 은 "Member as m" 이며 엔티티를 대상으로 하는 객체지향 SQL 이다.
            // select "m" from 의 "m"은 alias된 Member의 m 이다.

            tx.commit();
        }catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }

        emf.close();
    }
}
