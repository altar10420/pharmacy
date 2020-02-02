package pl.altar.pharmacy.repository;

import org.springframework.data.repository.CrudRepository;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.exception.EntityDoesNotExistException;

public interface ClientRepository extends CrudRepository<Client, Long> {

    default Client getById(Long id) {
        return findById(id).orElseThrow(() -> new EntityDoesNotExistException("Id: " + id + " not found!"));
    }
}
