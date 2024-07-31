package OneToOne;

import jakarta.persistence.*;


@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;

    public Team getTeam() {
        return team;
    }

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    // 마치 다대일 단방향 매핑처럼 FK 주인에다가 JoinColumn 어노테이션을 추가한다.
    private Locker locker;

    public void setTeam(Team team) {
        // 연관관계 편의 메소드
        this.team = team;
        team.getMembers().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
