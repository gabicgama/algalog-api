package com.algaworks.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.DeliveryModel;
import com.algaworks.algalog.api.model.input.DeliveryInput;
import com.algaworks.algalog.domain.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

	private ModelMapper modelMapper;

	public DeliveryModel toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryModel.class);
	}

	public List<DeliveryModel> toCollectionModel(List<Delivery> delivery) {
		return delivery.stream().map(this::toModel).collect(Collectors.toList());
	}

	public Delivery toEntity(DeliveryInput deliveryInput) {
		return modelMapper.map(deliveryInput, Delivery.class);
	}

}
