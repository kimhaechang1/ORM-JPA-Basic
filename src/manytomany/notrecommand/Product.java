package manytomany.notrecommand;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "products")
    List<Member> members = new ArrayList<>();
}
