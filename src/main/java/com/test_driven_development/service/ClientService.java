package com.test_driven_development.service;

import com.test_driven_development.entity.Client;
import com.test_driven_development.repository.ClientRepositoryI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepositoryI clientRepositoryI;

    public Client saveClient(Client client){
        return clientRepositoryI.save(client);
    }

    public List<Client> getClient() {
        List<Client> clients = (List<Client>) clientRepositoryI.findAll();
        return clients;
    }

    public Client getClientById(Long id){

        return clientRepositoryI.findById(id).orElse(null);

    }

    public String deleteClient(Long id){
        clientRepositoryI.deleteById(id);
        return "Client removed !!";
    }

    public  Client updateClient (Client client){
        Client existingClient = clientRepositoryI.findById(client.getId()).orElse(null);
        if(existingClient!=null){

            return clientRepositoryI.save(client);
        }
        return client;
    }

}
