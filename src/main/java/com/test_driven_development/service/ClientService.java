package com.test_driven_development.service;

import com.test_driven_development.entity.Client;
import com.test_driven_development.repository.ClientRepositoryI;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepositoryI clientRepositoryI;

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
//diff between allargs controller and require