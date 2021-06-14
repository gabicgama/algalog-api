package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Client client;

	@Embedded
	private Recipient recipient;

	private BigDecimal tax;

	@Enumerated(EnumType.STRING)
	private StatusDelivery status;

	private OffsetDateTime dateOrder;
	private OffsetDateTime dateEnded;

	@OneToMany(mappedBy = "delivery")
	private List<Occurrence> occurences = new ArrayList<>();

	public Occurrence addOccurrence(String description) {
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setDateRegistry(OffsetDateTime.now());
		occurrence.setDelivery(this);
		this.getOccurences().add(occurrence);
		return occurrence;
	}
}
