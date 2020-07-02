package br.com.client.clientapi.dtos.api.resquests;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientResquestDTO implements Serializable {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String dateBirth;
}
