package pl.altar.pharmacy.repository;

import org.springframework.data.repository.CrudRepository;
import pl.altar.pharmacy.domain.Bill;
import pl.altar.pharmacy.exception.EntityDoesNotExistException;

public interface BillRepository extends CrudRepository<Bill, Long> {

    default Bill getById(Long id) {
        return findById(id).orElseThrow(() -> new EntityDoesNotExistException("Id: " + id + " not found!"));
    }
}
