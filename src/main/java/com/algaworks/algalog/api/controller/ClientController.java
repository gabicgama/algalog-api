package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	ClientRepository repository;
	
	@GetMapping
	public List<Client> findAll() {
		return repository.findAll();
	}
}
