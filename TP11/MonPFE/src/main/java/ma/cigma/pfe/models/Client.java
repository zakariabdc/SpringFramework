package ma.cigma.pfe.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TClients")
//@Inheritance(strategy = InheritanceType.JOINED)
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="client_type")
@DiscriminatorValue("client")*/
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    //@Column
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Adresse",referencedColumnName = "id")
    private Adresse adresse;


    public Client(String name) {
        this.name = name;
    }
}
