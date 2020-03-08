package pl.altar.pharmacy.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.altar.pharmacy.domain.ProductCategory;
import pl.altar.pharmacy.service.BillService;
import pl.altar.pharmacy.service.ClientService;
import pl.altar.pharmacy.service.ProductService;

import java.math.BigDecimal;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ClientService clientService;
    private final ProductService productService;

    public BootStrapData(ClientService clientService, ProductService productService) {
        this.clientService = clientService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        clientService.createClient("John", "Travolta", 1954);
        clientService.createClient("Jeremy", "Irons", 1949);
        clientService.createClient("Sean", "Connory", 1941);

        productService.createProduct(
                "Ibuprom",
                true,
                BigDecimal.valueOf(12.50),
                ProductCategory.NON_PRESCRIPTION_MEDICINE);
        productService.createProduct(
                "Peniclilinum",
                true,
                BigDecimal.valueOf(28.50),
                ProductCategory.PRESCRIPTION_MEDICINE);
        productService.createProduct("Bandage",
                false,
                BigDecimal.valueOf(2.50),
                ProductCategory.OTHER);
    }
}
