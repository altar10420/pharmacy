package pl.altar.pharmacy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.altar.pharmacy.domain.Product;
import pl.altar.pharmacy.exception.EntityDoesNotExistException;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    default Product getById(Long id) {
        return findById(id).orElseThrow(() -> new EntityDoesNotExistException("Id: " + id + " not found!"));
    }
}
