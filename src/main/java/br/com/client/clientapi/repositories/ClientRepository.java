package br.com.client.clientapi.repositories;

import br.com.client.clientapi.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {

    Client findByid(String id);
}
