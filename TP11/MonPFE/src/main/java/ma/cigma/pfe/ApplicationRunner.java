package ma.cigma.pfe;

import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.presentation.ClientController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctrl = (ClientController) context.getBean("clientController");


        Client client1 = new Client("Zakaria");
        Client client2 = new Client("Walid");
        Client client3 = new Client("Riad");
// Test1 => save 3 Clients
        client1=ctrl.save(client1);
        client2=ctrl.save(client2);
        client3=ctrl.save(client3);
// Test2 => getAll Clients before modify and remove
        ctrl.getAll().stream()
                .forEach(i-> System.out.println(i));
// Test3 => getOne Client service
        System.out.println(ctrl.getOne(1));
// Test4 => modify Client service
        client1.setName("Hassan");
        ctrl.modify(client1);
// Test5 => remove Client service
        ctrl.remove(2);
// Test getAll Client after modify and remove
        ctrl.getAll().stream()
                .forEach(i-> System.out.println(i));


// Test getByName Client
        ctrl.getByName("Hassan").stream().forEach(i-> System.out.println("SELECT * FROM CLIENT WHERE NAME='HASSAN':"+i));
    }
}
