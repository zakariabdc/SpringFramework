package ma.cigma.controllers;

import ma.cigma.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ClientController {

    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = {"/", "/client"})
    public String home(Model model) {model.addAttribute("client",new Client());
        List<Client> clients = restTemplate.getForObject(apiUrl+"/client/all", List.class);
        model.addAttribute("clients",clients);
        return "index-client";
    }

    @PostMapping(value = "/add-client")
    public String addClient(Model model, @ModelAttribute("client") Client client) {
        restTemplate.postForObject(apiUrl+"/client/add", client, Client.class);
        return "redirect:/client";
    }
    @GetMapping(value = {"/delete-client/{id}"})
    public String deleteClientById(Model model, @PathVariable long id) {
        restTemplate.delete(apiUrl+"/client/"+id);
        return "redirect:/client";
    }
}
