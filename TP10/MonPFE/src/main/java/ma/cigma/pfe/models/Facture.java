package ma.cigma.pfe.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double amount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "my_join_table_facture_product",
            joinColumns = @JoinColumn(name = "facture_fk",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_fk", referencedColumnName = "id"))
    private List<Product> products;



    public Facture(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }
}
