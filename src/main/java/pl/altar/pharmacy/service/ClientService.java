package pl.altar.pharmacy.service;

import pl.altar.pharmacy.domain.Client;

import java.util.List;

public interface ClientService {

    Client getClient(Long id);

    Long createClient(String name, String surname, Integer yearOfBirth);

    Client updateClient(Long id, String name, String surname, Integer yearOfBirth);

    List<Client> getAllClients();

    Long removeClient(Long id);


}
