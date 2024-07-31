package OneToMany;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    // JPA 어노테이션은 어디까지나 DB에 적용시키는 설계를 하는것이다.
    // 1쪽에 주인임을 명시한다.
    // 그런데 Member를 Team에서 관리하는 꼴이므로, 실제 DB상에는 조인해야하는 컬럼은 TEAM_ID이다.
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
