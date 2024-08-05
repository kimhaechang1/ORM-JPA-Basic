package manytomany.recommand;

import jakarta.persistence.*;
import manytomany.notrecommand.Member;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    @OneToMany(mappedBy = "product")
    List<MemberProduct> memberProducts = new ArrayList<>();
}