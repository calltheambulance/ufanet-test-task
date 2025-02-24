package ru.stc.dantes.clientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stc.dantes.clientapi.dto.ClientDto;
import ru.stc.dantes.clientapi.model.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("SELECT new ru.stc.dantes.clientapi.dto.ClientDto(c.id, c.name) FROM Client c")
    List<ClientDto> findAllClients();
}
