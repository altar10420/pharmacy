package pl.altar.pharmacy.service;

import org.springframework.stereotype.Service;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public Long createClient(String name, String surname, Integer yearOfBirth) {

        Client client = new Client(null, name, surname, yearOfBirth);

        clientRepository.save(client);

        return client.getId();
    }

    @Override
    public Client updateClient(Long id, String name, String surname, Integer yearOfBirth) {

        Client client = clientRepository.getById(id);

        client.setName(name);
        client.setSurname(surname);
        client.setYearOfBirth(yearOfBirth);

        clientRepository.save(client);

        return clientRepository.getById(id);
    }

    @Override
    public List<Client> getAllClients() {

        List<Client> clientList = new ArrayList<>();

        for (Client client : clientRepository.findAll()) {

            clientList.add(client);
        }
        return clientList;
    }

    @Override
    public Long removeClient(Long id) {

        Client client = clientRepository.getById(id);
        clientRepository.deleteById(id);

        return client.getId();
    }
}
