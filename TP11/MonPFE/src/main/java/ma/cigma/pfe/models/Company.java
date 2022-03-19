package ma.cigma.pfe.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@IdClass(CompanyId.class)
public class Company {
    //@Id
    //private long rc;
    //@Id
    //private long idTribunal;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    @EmbeddedId
    private CompanyId id;

    private String name;
    private String address;
    private String phone;
    private String contactFirstName;
    private String contactLastName;
    private String contactPhone;

    @Embedded
    @AttributeOverride(name = "phone", column = @Column(name = "PHONE_CLIENT"))
    private ContactClient contactClient;
}
