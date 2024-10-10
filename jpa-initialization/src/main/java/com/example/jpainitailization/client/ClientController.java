package com.example.jpainitailization.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/client/update")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto) {
        Client client;
        Optional<Client> optionalClient = clientRepository.findById(clientDto.getId());
        client = optionalClient.orElseGet(() -> clientRepository.save(requestToModel(clientDto, new Client())));
        requestToModel(clientDto, client);
        clientRepository.save(client);
        return ResponseEntity.ok("ok");
    }

    private Client requestToModel(ClientDto clientDto, Client client) {
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setMiddleName(clientDto.getMiddleName());
        client.setFullName(clientDto.getFullName());
        return client;
    }
}
