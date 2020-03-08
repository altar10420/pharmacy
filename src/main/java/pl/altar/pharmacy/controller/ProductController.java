package pl.altar.pharmacy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.altar.pharmacy.controller.dto.ClientDTO;
import pl.altar.pharmacy.controller.dto.ProductDTO;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.domain.Product;
import pl.altar.pharmacy.domain.ProductCategory;
import pl.altar.pharmacy.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = ProductController.BASE_URL)
public class ProductController {

    public static final String BASE_URL = "/api/products";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "")
    public List<ProductDTO> getProductByCategory(@RequestParam(name = "category") ProductCategory productCategory) {

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productService.getProductByCategory(productCategory)) {
            productDTOList.add(new ProductDTO(product));
        }

        return productDTOList;
    }

    @GetMapping(path = "/getAll")
    public List<ProductDTO> productDTOList() {

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productService.getAllProducts()) {
            productDTOList.add(new ProductDTO(product));
        }

        return productDTOList;
    }
}
