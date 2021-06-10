package com.algaworks.algalog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;

	@Transactional
	public Client save(Client client) {
		boolean emailUsed = repository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(clientExists -> !clientExists.equals(client));
		
		if (emailUsed) {
			throw new DomainException("Já existe um cliente cadastrado com este e-mail.");
		}
		return repository.save(client);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
