package br.com.client.clientapi.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Client implements Serializable {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String dateBirth;
}
