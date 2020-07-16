package br.com.client.clientapi.service.Impl;

import br.com.client.clientapi.entities.Client;
import br.com.client.clientapi.repositories.ClientRepository;
import br.com.client.clientapi.services.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    public static final String ID = "1";
    public static final String NAME = "Anderson luiz sales";
    public static final String ADDRESS = "Campos salles";
    public static final String PHONE = "16997191541";
    public static final String DATE_BIRTH = "22/04/1995";

    @Test
    private void saveSucessTest() {
        Client client = createClient();
        when(clientRepository.save(client)).thenReturn(client);
        Client save = clientService.save(client);
        assertEquals(client, save);
    }

    @Test
    public void listSucessTest() {
        List<Client> clients = createListCLient();
        when(clientRepository.findAll()).thenReturn(clients);
        List<Client> clients1 = clientService.getClients();
        assertEquals(clients, clients);
    }

    @Test
    public void findByIdSucessTest() {
        Client client = createClient();
        when(clientRepository.findByid(ID)).thenReturn(client);
        Client byId = clientService.findById(ID);
        assertEquals(client, byId);
    }

    @Test
    public void deleteByIdSucessTest() {
        ClientRepository clientRepository = mock(ClientRepository.class);
        ArgumentCaptor valCapture = ArgumentCaptor.forClass(String.class);
        doNothing().when(clientRepository).deleteById((String) valCapture.capture());
        clientRepository.deleteById("ID");
        clientService.deleteById(ID);
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

    private List<Client> createListCLient() {
        Client client = createClient();
        List<Client> clientsList = new ArrayList<>();
        clientsList.add(client);

        return clientsList;
    }
}
