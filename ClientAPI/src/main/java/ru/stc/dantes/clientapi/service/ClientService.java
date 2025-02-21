package ru.stc.dantes.clientapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stc.dantes.clientapi.dto.ClientRequest;
import ru.stc.dantes.clientapi.model.Client;
import ru.stc.dantes.clientapi.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void addClient(ClientRequest request) {
        Client client = Client
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
        clientRepository.save(client);
        log.info("Добавлен новый клиент {id}", client.getId());
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }
}
