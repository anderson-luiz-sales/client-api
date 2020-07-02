package br.com.client.clientapi.dtos.api.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientResponseDTO implements Serializable {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String dateBirth;
}
