package br.com.client.clientapi.services;

import br.com.client.clientapi.entities.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);
    List<Client> getClients();
    Client findById(String id);
    void deleteById(String id);
}
