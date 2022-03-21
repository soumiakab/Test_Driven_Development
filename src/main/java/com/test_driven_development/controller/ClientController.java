package com.test_driven_development.controller;

import com.test_driven_development.entity.Client;
import com.test_driven_development.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController{

    @Autowired
    ClientService clientService;


    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient(){
        return  ResponseEntity.ok(clientService.getClient());
    }

    @GetMapping("/{id}")
    public Client findClientById(@PathVariable long id){
        return clientService.getClientById(id);
    }

    @PostMapping("/add")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable long id){
        return clientService.deleteClient(id);
    }

}
