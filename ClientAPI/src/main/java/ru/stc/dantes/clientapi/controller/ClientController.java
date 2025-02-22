package ru.stc.dantes.clientapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.stc.dantes.clientapi.dto.ClientRequest;
import ru.stc.dantes.clientapi.model.Client;
import ru.stc.dantes.clientapi.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/pool/client")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients() {
        //TODO: Спросить должен ли этот метод возвращать все поля, или всё таки id и name
        return clientService.getAllClients();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public void addClient(@Valid @RequestBody ClientRequest request) {
        clientService.addClient(request);
    }

    @PostMapping("/update/{id}")
    public Client updateClient(@PathVariable("id") int id, @Valid @RequestBody Client updatedClient) {
        return clientService.updateClient(id, updatedClient);
    }
}
