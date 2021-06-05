package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@GetMapping
	public List<Client> findAll() {
		var client1 = new Client();
		client1.setId(1L);
		client1.setName("João");
		client1.setPhone("34 99999-1111");
		client1.setEmail("joaodascouves@algaworks.com");
		
		var client2 = new Client();
		client2.setId(2L);
		client2.setName("Maria");
		client2.setPhone("11 97777-2222");
		client2.setEmail("mariadasilva@algaworks.com");
		
		return Arrays.asList(client1, client2);
	}
}
