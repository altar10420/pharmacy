package pl.altar.pharmacy.service;

import org.springframework.stereotype.Service;
import pl.altar.pharmacy.controller.dto.ProductDTO;
import pl.altar.pharmacy.domain.Product;
import pl.altar.pharmacy.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<>();

        for (Product product : productRepository.findAll()) {
            productList.add(product);
        }

        return productList;
    }

    @Override
    public Long createProduct(String name, Boolean isAvailable, BigDecimal price) {

        Product product = new Product(name, isAvailable, price);
        productRepository.save(product);
        return product.getId();
    }
}
