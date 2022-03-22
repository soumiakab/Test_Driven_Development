package com.test_driven_development.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test_driven_development.entity.Client;
import com.test_driven_development.enumeration.SexEnum;
import com.test_driven_development.repository.ClientRepositoryI;
import com.test_driven_development.service.ClientService;
import com.test_driven_development.util.JsonUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientControllerTest.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientControllerTest {


    @MockBean
    ClientService clientService;

    @MockBean
    ClientRepositoryI clientRepositoryI;

    @MockBean
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

        List<Client> clients = new ArrayList<>();
        clients.add(client);
        given(clientService.getClient()).willReturn(clients);


        mockMvc.perform(get("/api/client/all")).andExpect(status().isOk()).
        andDo(MockMvcResultHandlers.print());

    }

    @Test
    void findClientById() throws Exception {

        Mockito.lenient().when(clientService.getClientById(client.getId())).thenReturn(client);
        mockMvc.perform(get("/api/client/"+client.getId())).andExpect(status().isOk()).
                andDo(MockMvcResultHandlers.print());

    }

    @Test
    void saveClient() throws Exception {
        when(clientService.saveClient(any())).thenReturn(client);

        mockMvc.perform(post("/api/client/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(client)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.fullName").value(client.getFullName()));
    }

    @Test
    void updateClient() throws Exception {
        given(clientService.updateClient(client)).willReturn(client);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(put("/api/client/update")
                        .content(mapper.writeValueAsString(client))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteClient() throws Exception {
        given(clientService.deleteClient(client.getId())).willReturn("deleted");

        mockMvc.perform(delete("/api/client//delete/"+client.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}