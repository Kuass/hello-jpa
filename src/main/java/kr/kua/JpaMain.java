package kr.kua;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setTeam(team);

            em.flush();
            em.clear();

            String query = "SELECT m FROM Member m, Team t where m.username = t.name";
            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();

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
