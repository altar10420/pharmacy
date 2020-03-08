package pl.altar.pharmacy.controller.dto;

import lombok.Data;
import pl.altar.pharmacy.domain.Product;
import pl.altar.pharmacy.domain.ProductCategory;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Boolean isAvailable;
    private BigDecimal price;
    private ProductCategory productCategory;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.isAvailable = product.getIsAvailable();
        this.price = product.getPrice();
        this.productCategory = product.getProductCategory();
    }
}
