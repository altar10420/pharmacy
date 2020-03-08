package pl.altar.pharmacy.service;

import pl.altar.pharmacy.domain.Product;
import pl.altar.pharmacy.domain.ProductCategory;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product getProduct(Long id);

    List<Product> getProductByCategory(ProductCategory productCategory);

    List<Product> getAllProducts();

    Long createProduct(String name, Boolean isAvailable, BigDecimal price, ProductCategory productCategory);
}
