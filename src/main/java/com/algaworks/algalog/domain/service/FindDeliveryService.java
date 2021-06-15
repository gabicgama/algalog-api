package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.EntityNotFoundException;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

public class FindDeliveryService {

	private DeliveryRepository repository;

	public Delivery findById(Long deliveryId) {
		return repository.findById(deliveryId).orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
	}
}
