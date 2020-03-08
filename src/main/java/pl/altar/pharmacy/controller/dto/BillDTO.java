package pl.altar.pharmacy.controller.dto;

import lombok.Data;
import pl.altar.pharmacy.domain.Bill;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.domain.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BillDTO {

    private Long id;
    private LocalDateTime dateTime;
    private BigDecimal price;
    private ClientDTO client;
    private List<ProductDTO> products = new ArrayList<>();

    public BillDTO() {
    }

    public BillDTO(Bill bill) {
        this.id = bill.getId();
        this.dateTime = bill.getDateTime();
        this.price = bill.getPrice();
        this.client = new ClientDTO(bill.getClient());

        for (Product product : bill.getProducts()) {
            if (product.getIsAvailable().equals(true)) {
                this.products.add(new ProductDTO(product));
            }
        }
    }
}
