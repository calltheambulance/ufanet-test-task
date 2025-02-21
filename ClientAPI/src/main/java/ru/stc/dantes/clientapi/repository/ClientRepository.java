package ru.stc.dantes.clientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stc.dantes.clientapi.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
