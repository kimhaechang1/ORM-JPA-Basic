package OneToOne;

import jakarta.persistence.*;

@Entity
public class Locker {
    // 모든 각 회원은 하나의 Locker를 가진다.
    // 1:1 매핑

    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    // 만약 Locker도 Member를 알고싶다면?
    // 연관관계 주인이 누군지 명시해야하는 다대일 양방향 매핑과 같이 해주면 된다.
    // 단 일대일의 반대는 일대일이므로 OneToOne 어노테이션을 사용한다.
    @OneToOne(mappedBy = "locker")
    private Member member;

    private String name;
}
