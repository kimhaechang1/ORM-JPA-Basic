package manytomany.recommand;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "member")
    List<MemberProduct> memberProducts = new ArrayList<>();

}