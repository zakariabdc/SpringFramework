package ma.cigma.pfe.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Controller("ctrl")
public class ClientController {
    @Autowired
    private IClientService service;

    public Client save(Client c){
        return service.save(c);
    }
    public Client modify(Client c){
        return service.modify(c);
    }
    public void removeById(long id){
        service.removeById(id);
    }
    public Client getById(long id){
        return service.getById(id);
    }
}
