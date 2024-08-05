package manytomany.notrecommand;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    Long id;

    @ManyToMany
    @JoinTable
    List<Product> products = new ArrayList<>();
}
