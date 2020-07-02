package br.com.client.clientapi.services.impl;

import br.com.client.clientapi.entities.Client;
import br.com.client.clientapi.repositories.ClientRepository;
import br.com.client.clientapi.services.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        log.info("[ClientServiceImpl.save] - client: {}", client);
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        log.info("[ClientServiceImpl.findAll]");
        return clientRepository.findAll();
    }

    @Override
    public Client findById(String id) {
        log.info("[ClientServiceImpl.findById] - id: {}", id);
        return clientRepository.findByid(id);
    }

    @Override
    public void deleteById(String id) {
        log.info("[ClientServiceImpl.deleteById] - id: {}", id);
        clientRepository.deleteById(id);
    }
}
