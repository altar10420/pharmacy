package pl.altar.pharmacy.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean isAvailable;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @ManyToMany(mappedBy = "products", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Bill> bills;

    public Product() {
    }

    public Product(String name, Boolean isAvailable, BigDecimal price, ProductCategory productCategory) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.price = price;
        this.productCategory = productCategory;
    }
}
