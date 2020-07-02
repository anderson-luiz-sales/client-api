package br.com.client.clientapi.controllers;

import br.com.client.clientapi.dtos.api.responses.ClientResponseDTO;
import br.com.client.clientapi.dtos.api.resquests.ClientResquestDTO;
import br.com.client.clientapi.facades.ClientFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app-consumer/v1/clients")
@CrossOrigin(origins = "*")
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ClientController {

    private final ClientFacade clientFacade;

    @ApiOperation(value = "Post Clients v1")
    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody ClientResquestDTO clientResquestDTO) {
        return new ResponseEntity<>(clientFacade.save(clientResquestDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Clients v1")
    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> list() {
        return new ResponseEntity<>(clientFacade.getClients(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get By Id Clients v1")
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(clientFacade.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Put Clients v1")
    @PutMapping
    public ResponseEntity<ClientResponseDTO> update(@RequestBody ClientResquestDTO clientResquestDTO) {
        return new ResponseEntity<>(clientFacade.update(clientResquestDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Clients v1")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        clientFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
