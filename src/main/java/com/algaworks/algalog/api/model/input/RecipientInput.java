package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientInput {

	@NotBlank
	private String name;

	@NotBlank
	private String street;

	@NotBlank
	private String nummber;

	@NotBlank
	private String complement;

	@NotBlank
	private String neighborhood;
}
