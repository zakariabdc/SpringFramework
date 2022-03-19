package ma.cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TClients")
@Inheritance(strategy = InheritanceType.JOINED)
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="client_type")
@DiscriminatorValue("client")*/
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    //@Column
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private List<Facture> factures;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="my_join_table_client_promotion",joinColumns = @JoinColumn(
            name = "client_fk",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "promotion_fk", referencedColumnName = "id"))
    private List<Promotion> promotions;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Adresse",referencedColumnName = "id")
    private Adresse adresse;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private CarteFidelio carteFidelio;

    public Client(String name) {
        this.name = name;
    }
}
