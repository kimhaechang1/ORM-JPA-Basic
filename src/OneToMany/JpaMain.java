package OneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
            member.setTeam(team);
            em.persist(member);


            // 여기까지는 Team 테이블과 연관이 있다.
            // 하지만 member를 추가하는것은 Member 테이블과 관련 있다.
            // 그래서 미리 들어간 member 엔티티에 대해서 update쿼리가 발생한다. (팀 정보 기입

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();


    }
}
