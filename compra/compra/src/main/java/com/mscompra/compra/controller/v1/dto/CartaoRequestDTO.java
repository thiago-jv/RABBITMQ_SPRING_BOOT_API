package com.mscompra.compra.controller.v1.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CartaoRequestDTO implements Serializable {

    @ApiModelProperty(value = "número cartao", example = "231315485214", required = true)
    private String numero;
    @ApiModelProperty(value = "limite do cartão", example = "2000", required = true)
    private BigDecimal limite_disponivel;
}
