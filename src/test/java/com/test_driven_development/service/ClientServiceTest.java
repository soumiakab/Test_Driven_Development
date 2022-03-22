package com.test_driven_development.service;

import com.test_driven_development.entity.Client;
import com.test_driven_development.enumeration.SexEnum;
import com.test_driven_development.repository.ClientRepositoryI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientServiceTest {

//    @Mock
//    ClientRepositoryI clientRepositoryI;
//
//    @InjectMocks
//    ClientService clientService;
//
//    Client client;
//
//    @BeforeEach
//    void initClient(){
//        client=new Client(1L,"email@gmail.com","+2122828237","fullName",21, SexEnum.F,true);
//    }
//
//    @Test
//    void saveClient() {
//        Mockito.lenient().when(clientRepositoryI.save(client)).thenReturn(client);
//       // Mockito.when(clientService.saveClient(client)).thenReturn(client);
//        Client client1= clientService.saveClient(client);
//        System.out.println(client);
//        System.out.println(client1);
//        assertThat(client).isEqualTo(client1);
//    }
//
//    @Test
//    void getClient() {
//        List<Client> clients = new ArrayList<>();
//        clients.add(client);
//
//        given(clientRepositoryI.findAll()).willReturn(clients);
//
//        List<Client> clients2 = clientService.getClient();
//
//        assertEquals(clients2, clients);
//
//        //to verify
//        verify(clientRepositoryI).findAll();
//    }
//
//    @Test
//    void getClientById() {
//       // doReturn(Optional.of(client)).when(clientRepositoryI).findById(1L);
//        Mockito.lenient().when(clientRepositoryI.findById(1L)).thenReturn(Optional.of(client));
//         //Mockito.when(clientService.getClientById(1L)).thenReturn(client);
//        Client client1= clientService.getClientById(1L);
//        assertThat(client1).isEqualTo(client);
//    }
//
//    @Test
//    void deleteClient() {
//        Mockito.lenient().when(clientRepositoryI.findById(1L)).thenReturn(Optional.of(client));
//        clientService.deleteClient(client.getId());
//
//    }
//
//    @Test
//    void updateClient() {
//        Mockito.lenient().when(clientRepositoryI.findById(1L)).thenReturn(Optional.of(client));
//        Mockito.lenient().when(clientRepositoryI.save(client)).thenReturn(client);
//        Client client1= clientService.updateClient(client);
//        assertThat(client).isEqualTo(client1);
//    }

}