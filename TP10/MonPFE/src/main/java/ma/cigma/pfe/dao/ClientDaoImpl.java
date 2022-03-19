package ma.cigma.pfe.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cigma.pfe.models.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Repository
public class ClientDaoImpl implements IClientDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Client save(Client c){
        em.persist(c);
        return c;
    }

    @Override
    public Client update(Client c) {
        Client currentClient = em.find(Client.class,c.getId());
        currentClient.setName(c.getName());
        em.persist(currentClient);
        return c;
    }

    @Override
    public void deleteById(long idClient) {
        Client clientInDataBase = em.find(Client.class,idClient);
        em.remove(clientInDataBase);
    }

    @Override
    public Client findById(long idClient) {
        return em.find(Client.class,idClient);
    }
}
