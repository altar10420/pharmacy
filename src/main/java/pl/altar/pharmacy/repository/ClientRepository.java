package pl.altar.pharmacy.repository;

import org.springframework.data.repository.CrudRepository;
import pl.altar.pharmacy.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
