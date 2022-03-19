package ma.cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String avenue,ville,pays;

    @OneToOne(mappedBy = "adresse")
    private Client client;

    public Adresse(String avenue, String ville, String pays, Client client) {
        this.avenue = avenue;
        this.ville = ville;
        this.pays = pays;
        this.client = client;
    }
}
