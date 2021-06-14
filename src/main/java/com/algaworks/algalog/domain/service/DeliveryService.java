package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.StatusDelivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	DeliveryRepository repository;

	@Autowired
	ClientService ClientService;

	@Transactional
	public Delivery order(Delivery delivery) {
		Client client = ClientService.findById(delivery.getClient().getId());
		delivery.setClient(client);
		delivery.setStatus(StatusDelivery.PENDING);
		delivery.setDateOrder(LocalDateTime.now());
		return repository.save(delivery);
	}
}
