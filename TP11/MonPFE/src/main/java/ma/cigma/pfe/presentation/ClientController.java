package ma.cigma.pfe.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller("clientController")
public class ClientController {
    @Autowired
    private IClientService service;

    public Client save(Client clt) {
        return service.save(clt);
    }
    public Client modify(Client clt) {
        return service.modify(clt);
    } public void remove(long idClt) {
        service.remove(idClt);
    } public Client getOne(long idClt) {
        return service.getOne(idClt);
    } public List<Client> getAll() {
        return service.getAll();
    }
    public List<Client> getByName(String name){
        return service.getByName(name);
    }
}
