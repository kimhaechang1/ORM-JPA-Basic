package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 어플리케이션 실행시 딱 하나만 만들어진다.
        EntityManager em = emf.createEntityManager();
        // 하나의 트랜잭션 단위당 하나
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member find = em.find(Member.class, 10L);
            find.setUsername("유저2");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
