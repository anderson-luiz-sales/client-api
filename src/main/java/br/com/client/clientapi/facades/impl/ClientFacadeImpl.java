package br.com.client.clientapi.facades.impl;

import br.com.client.clientapi.dtos.api.responses.ClientResponseDTO;
import br.com.client.clientapi.dtos.api.resquests.ClientResquestDTO;
import br.com.client.clientapi.entities.Client;
import br.com.client.clientapi.facades.ClientFacade;
import br.com.client.clientapi.services.ClientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ClientFacadeImpl implements ClientFacade {

    private final ClientService clientService;

    private final ModelMapper modelMapper;

    @Override
    public ClientResponseDTO save(ClientResquestDTO clientResquestDTO) {
        return convertToDTO(clientService.save(convertToEntity(clientResquestDTO)));
    }

    @Override
    public List<ClientResponseDTO> getClients() {
        List<ClientResponseDTO> clientList = new ArrayList<>();

        for (Client client : clientService.getClients()) {
            clientList.add(convertToDTO(client));
        }
        return clientList;
    }

    @Override
    public ClientResponseDTO findById(String id) {
        return convertToDTO(clientService.findById(id));
    }

    @Override
    public ClientResponseDTO update(ClientResquestDTO clientResquestDTO) {
        return convertToDTO(clientService.save(convertToEntity(clientResquestDTO)));
    }

    @Override
    public void deleteById(String id) {
        clientService.deleteById(id);
    }

    private Client convertToEntity(ClientResquestDTO clientResquestDTO) {
        return modelMapper.map(clientResquestDTO, Client.class);
    }

    private ClientResponseDTO convertToDTO(Client client) {
        return modelMapper.map(client, ClientResponseDTO.class);
    }
}
