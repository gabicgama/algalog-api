package com.algaworks.algalog.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.service.DeliveryService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryController {

	@Autowired
	DeliveryService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery order(@RequestBody Delivery delivery) {
		return service.order(delivery);
	}
}
