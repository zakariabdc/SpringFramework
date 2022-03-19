package ma.cigma.pfe.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarteFidelio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;

    @OneToOne
    @JoinColumn(name="carte_client_id")
    private Client client;

    public CarteFidelio(String code) {
        this.code = code;
    }
}
