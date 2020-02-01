package pl.altar.pharmacy.service;

import org.springframework.stereotype.Service;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }
}
