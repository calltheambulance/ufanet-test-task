package ru.stc.dantes.clientapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stc.dantes.clientapi.dto.ClientRequest;
import ru.stc.dantes.clientapi.model.Client;
import ru.stc.dantes.clientapi.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/pool/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients() {
        List<Client> clients = clientService.getAllClients();
        //TODO: Спросить должен ли этот метод возвращать все поля, или всё таки id и name
        return null;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public void addClient(@RequestBody ClientRequest request) {
        clientService.addClient(request);
    }

    @PostMapping("/update")
    public void updateClient(@RequestBody ClientRequest request) {

    }
}
