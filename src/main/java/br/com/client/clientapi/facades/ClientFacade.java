package br.com.client.clientapi.facades;

import br.com.client.clientapi.dtos.api.responses.ClientResponseDTO;
import br.com.client.clientapi.dtos.api.resquests.ClientResquestDTO;

import java.util.List;

public interface ClientFacade {

    ClientResponseDTO save(ClientResquestDTO clientResquestDTO);
    List<ClientResponseDTO> getClients();
    ClientResponseDTO findById(String id);
    ClientResponseDTO update(ClientResquestDTO clientResquestDTO);
    void deleteById(String id);
}
