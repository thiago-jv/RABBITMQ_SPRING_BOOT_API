package com.mscompra.compra.domain.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Embeddable
public class Endereco {
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;

	private String uf;
	
	private String localidade;
	
}
