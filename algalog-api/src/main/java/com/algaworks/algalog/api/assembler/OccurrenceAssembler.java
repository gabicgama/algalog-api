package com.algaworks.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.OccurrenceModel;
import com.algaworks.algalog.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {

	private ModelMapper modelMapper;

	public OccurrenceModel toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceModel.class);
	}

	public List<OccurrenceModel> toCollectionModel(List<Occurrence> occurrences) {
		return occurrences.stream().map(this::toModel).collect(Collectors.toList());
	}

}
