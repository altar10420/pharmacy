package pl.altar.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.altar.pharmacy.controller.dto.ClientDTO;
import pl.altar.pharmacy.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/{id}")
    public ClientDTO getClient(@PathVariable("id") Long id) {

        return new ClientDTO(clientService.getClient(id));
    }
}
