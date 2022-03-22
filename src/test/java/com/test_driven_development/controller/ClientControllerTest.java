package com.test_driven_development.controller;

import com.test_driven_development.entity.Client;
import com.test_driven_development.enumeration.SexEnum;
import com.test_driven_development.repository.ClientRepositoryI;
import com.test_driven_development.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientControllerTest.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientControllerTest {


    @MockBean
    ClientService clientService;

    @InjectMocks
    ClientController clientController;

    @Autowired
    private MockMvc mockMvc;

    Client client;

    @BeforeEach
    void initClient(){
        client=new Client(1L,"email@gmail.com","+2122828237","fullName",21, SexEnum.F,true);
    }


    @Test
    void getAllClient() throws Exception {
//        List<Client> clients = new ArrayList<>();
//        clients.add(client);
//
//        given(clientService.getClient()).willReturn(clients);
//
//        mockMvc.perform(get("/api/client/all"))
//                .andExpect(status().isOk());

    }

    @Test
    void findClientById() {
    }

    @Test
    void saveClient() {
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }
}