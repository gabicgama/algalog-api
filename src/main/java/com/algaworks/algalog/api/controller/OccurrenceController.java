package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.OccurrenceAssembler;
import com.algaworks.algalog.api.model.OccurrenceModel;
import com.algaworks.algalog.api.model.input.OccurrenceInput;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;
import com.algaworks.algalog.domain.service.FindDeliveryService;
import com.algaworks.algalog.domain.service.RegisterOccurrenceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/deliveries/{id}/occurrences")
public class OccurrenceController {

	private FindDeliveryService findDeliveryService;
	private RegisterOccurrenceService registerOccurrenceService;
	private OccurrenceAssembler occurrenceAssembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceModel register(@PathVariable Long deliveryId,
			@Valid @RequestBody OccurrenceInput occurrenceInput) {

		Occurrence occurrenceRegistry = registerOccurrenceService.register(deliveryId,
				occurrenceInput.getDescription());

		return occurrenceAssembler.toModel(occurrenceRegistry);
	}
	
	@GetMapping
	public List<OccurrenceModel> allOccurrencesById(@PathVariable Long deliveryId) {
		Delivery delivery = findDeliveryService.findById(deliveryId);
		return occurrenceAssembler.toCollectionModel(delivery.getOccurrences());
	}
}
