package pl.altar.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.altar.pharmacy.controller.dto.ClientDTO;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.service.ClientService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ClientController.BASE_URL)
public class ClientController {

    public static final String BASE_URL = "/api/clients";

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/{id}")
    public ClientDTO getClient(@PathVariable("id") Long id) {
        return new ClientDTO(clientService.getClient(id));
    }

    @PostMapping
    public Long createClient(@RequestBody ClientDTO clientDTO) {

        Long clientId = clientService.createClient(
                clientDTO.getName(),
                clientDTO.getSurname(),
                clientDTO.getYearOfBirth());

        return clientId;
    }

    @PutMapping(path = "/{id}")
    public ClientDTO updateClient(@PathVariable("id") Long id,
                                  @RequestBody ClientDTO clientDTO) {

        clientService.updateClient(
                id,
                clientDTO.getName(),
                clientDTO.getSurname(),
                clientDTO.getYearOfBirth());

        return new ClientDTO(clientService.getClient(id));
    }

    @DeleteMapping(path = "/{id}")
    public Long removeClient(@PathVariable("id") Long id) {
        return clientService.removeClient(id);
    }

    @GetMapping(path = "/getAll")
    public List<ClientDTO> clientDTOList() {

        List<ClientDTO> clientDTOList = new ArrayList<>();

        for (Client client : clientService.getAllClients()) {
            clientDTOList.add(new ClientDTO(client));
        }

        return clientDTOList;
    }
}
