package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.DeliveryAssembler;
import com.algaworks.algalog.api.model.DeliveryModel;
import com.algaworks.algalog.api.model.input.DeliveryInput;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.EndDeliveryService;
import com.algaworks.algalog.domain.service.OrderDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryController {

	OrderDeliveryService service;
	DeliveryRepository deliveryRepository;
	DeliveryAssembler deliveryAssembler;
	EndDeliveryService endDeliveryService;

	@GetMapping
	public List<DeliveryModel> findAll() {
		return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeliveryModel> findById(@PathVariable Long id) {
		return deliveryRepository.findById(id).map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryModel order(@Valid @RequestBody DeliveryInput deliveryInput) {
		Delivery delivery = deliveryAssembler.toEntity(deliveryInput);
		return deliveryAssembler.toModel(service.order(delivery));
	}

	@PutMapping("/{id}/end")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void end(@PathVariable Long deliveryId) {
		endDeliveryService.end(deliveryId);
	}
}
