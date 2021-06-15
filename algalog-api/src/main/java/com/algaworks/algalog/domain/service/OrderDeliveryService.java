package com.algaworks.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.StatusDelivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderDeliveryService {

	DeliveryRepository repository;
	ClientService ClientService;

	@Transactional
	public Delivery order(Delivery delivery) {
		Client client = ClientService.findById(delivery.getClient().getId());
		delivery.setClient(client);
		delivery.setStatus(StatusDelivery.PENDING);
		delivery.setDateOrder(OffsetDateTime.now());
		return repository.save(delivery);
	}
}
