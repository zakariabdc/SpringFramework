package ma.cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="vip_id")
//@DiscriminatorValue("vip")
public class ClientVip extends Client{
    private String preferences;
    public ClientVip(String name, String preferences) {
        super(name);
        this.preferences = preferences;
    }
}