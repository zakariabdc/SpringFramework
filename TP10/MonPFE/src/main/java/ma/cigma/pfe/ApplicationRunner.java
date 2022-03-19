package ma.cigma.pfe;

import ma.cigma.pfe.models.CarteFidelio;
import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.models.Facture;
import ma.cigma.pfe.models.Promotion;
import ma.cigma.pfe.presentation.ClientController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctrl = (ClientController) context.getBean("ctrl");

        Client client = new Client("OMAR");
        /*
        //Facture
        List<Facture> factures = Arrays.asList(new Facture(1500.0,"facture1"),
                new Facture(2000.0,"facture2"));
        client.setFactures(factures);
        //Promotion
        List<Promotion> promotions = Arrays.asList(new Promotion("remise 10%"),
                new Promotion("solde 40%"));
        client.setPromotions(promotions);
        //CarteFidelio
        CarteFidelio carteFidelio = new CarteFidelio("A29930489");
        carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);
        */
        ctrl.save(client);


        /*
        ctrl.save(new Client("Zakaria"));
        ctrl.save(new Client("Walid"));
        ctrl.save(new Client("Riad"));
        ctrl.save(new Client("Ghoufrane"));
        //Update
        ctrl.modify(new Client(1,"NEW NAME"));
        //Delete
        ctrl.removeById(1);
        //Select
        Client found = ctrl.getById(2);
        System.out.println(found);
        //Select *

            //TP8 (10pts)
            List<Client> clientList = ctrl.getAll();
            clt.forEach(c -> System.out.println(c));
         */
    }
}
