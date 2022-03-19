package ma.cigma.pfe.models;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class ContactClient {
    private String firstName;
    private String lastName;
    private String phone;
}
