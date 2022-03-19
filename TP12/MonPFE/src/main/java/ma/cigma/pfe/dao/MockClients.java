package ma.cigma.pfe.dao;

import ma.cigma.pfe.dao.IClientDao;
import ma.cigma.pfe.models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MockClients implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MockClients.class);
    @Autowired
    private IClientDao dao;
    @Override
    public void run(String... args) throws Exception {
        Client c1 = new Client("Zakaria");
        Client c2 = new Client("Walid");
        Client c3 = new Client("Riad");
        Client c4 = new Client("Ghoufrane");
        dao.save(c1);
        dao.save(c2);
        dao.save(c3);
        dao.save(c4);
        dao.findAll().forEach(c -> System.out.println(c));
    }
}
