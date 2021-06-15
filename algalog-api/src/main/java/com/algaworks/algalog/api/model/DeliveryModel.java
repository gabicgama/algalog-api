package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.StatusDelivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryModel {

	private Long id;
	private ClientResumeModel client;
	private BigDecimal tax;
	private StatusDelivery status;
	private OffsetDateTime dateOrder;
	private OffsetDateTime dateEnded;
	private RecipientModel recipient;

}
