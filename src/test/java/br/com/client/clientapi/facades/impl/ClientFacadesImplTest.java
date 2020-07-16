package br.com.client.clientapi.facades.impl;

import br.com.client.clientapi.dtos.api.responses.ClientResponseDTO;
import br.com.client.clientapi.dtos.api.resquests.ClientResquestDTO;
import br.com.client.clientapi.entities.Client;
import br.com.client.clientapi.services.ClientService;
import br.com.client.clientapi.services.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientFacadesImplTest {

    @InjectMocks
    ClientFacadeImpl clientFacade;

    @Mock
    ClientService clientService;

    @Mock
    private ModelMapper modelMapper;

    public static final String ID = "1";
    public static final String NAME = "Anderson luiz sales";
    public static final String ADDRESS = "Campos salles";
    public static final String PHONE = "16997191541";
    public static final String DATE_BIRTH = "22/04/1995";

    @Test
    public void saveSucessTest() {
        Client client = createClient();
        ClientResquestDTO clientResquestDTO = createClientResquestDTO();
        when(clientService.save(client)).thenReturn(client);
        ClientResponseDTO clientResponseDTO = clientFacade.save(clientResquestDTO);
        assertEquals(convertToDTO(client), clientResponseDTO);
    }

    @Test
    public void listSucessTest() {
        List<ClientResponseDTO> clientList = createListClientResponseDTO();
        List<Client> clients = createListClient();
        when(clientService.getClients()).thenReturn(clients);
        List<ClientResponseDTO> list = clientFacade.getClients();

        List<ClientResponseDTO> collect = clients.stream().map(client -> convertToDTO(client)).collect(Collectors.toList());

        assertEquals(collect, list);
    }

    @Test
    public void findByIdSucessTest() {
        Client client = createClient();

        when(clientService.findById(ID)).thenReturn(client);
        ClientResponseDTO byId = clientFacade.findById(ID);

        assertEquals(convertToDTO(client), byId);
    }

    @Test
    public void updateSucessTest() {
        Client client = createClient();
        ClientResquestDTO clientResquestDTO = createClientResquestDTO();
        when(clientService.save(convertToEntity(clientResquestDTO))).thenReturn(client);
        ClientResponseDTO update = clientFacade.update(clientResquestDTO);
        assertEquals(convertToDTO(client), update);
    }

    @Test
    public void deleteByIdSucessTest() {
        ClientService clientService = mock(ClientServiceImpl.class);
        ArgumentCaptor valCapture = ArgumentCaptor.forClass(String.class);
        doNothing().when(clientService).deleteById((String) valCapture.capture());
        clientService.deleteById("ID");
        clientFacade.deleteById(ID);
        assertEquals("ID", valCapture.getValue());
    }

    private Client createClient() {
        Client client = new Client();

        client.setId(ID);
        client.setName(NAME);
        client.setAddress(ADDRESS);
        client.setPhone(PHONE);
        client.setDateBirth(DATE_BIRTH);

        return client;
    }

    private List<Client> createListClient() {
        Client client = createClient();
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        return clientList;
    }

    private ClientResquestDTO createClientResquestDTO() {
        ClientResquestDTO clientResquestDTO = new ClientResquestDTO();

        clientResquestDTO.setId(ID);
        clientResquestDTO.setName(NAME);
        clientResquestDTO.setAddress(ADDRESS);
        clientResquestDTO.setPhone(PHONE);
        clientResquestDTO.setDateBirth(DATE_BIRTH);

        return clientResquestDTO;
    }

    private List<ClientResponseDTO> createListClientResponseDTO() {
        List<ClientResponseDTO> clientListResponseDTO = new ArrayList<>();

        ClientResponseDTO clientResponseDTO = createClientResponseDTO();
        clientListResponseDTO.add(clientResponseDTO);

        return clientListResponseDTO;
    }

    private ClientResponseDTO createClientResponseDTO() {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();

        clientResponseDTO.setId(ID);
        clientResponseDTO.setName(NAME);
        clientResponseDTO.setAddress(ADDRESS);
        clientResponseDTO.setPhone(PHONE);
        clientResponseDTO.setDateBirth(DATE_BIRTH);

        return clientResponseDTO;
    }

    private Client convertToEntity(ClientResquestDTO clientResquestDTO) {
        return modelMapper.map(clientResquestDTO, Client.class);
    }

    private ClientResponseDTO convertToDTO(Client client) {
        return modelMapper.map(client, ClientResponseDTO.class);
    }
}