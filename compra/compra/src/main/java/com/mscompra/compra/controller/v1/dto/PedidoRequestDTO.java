package com.mscompra.compra.controller.v1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PedidoRequestDTO {

    @ApiModelProperty(value = "email", example = "thiago.henrique.23@hotmail.com", required = true)
    private String email;
    @ApiModelProperty(value = "nome", example = "thiago henrique", required = true)
    private String nome;
    @ApiModelProperty(value = "id propduto", example = "1", required = true)
    private Long produto;
    @ApiModelProperty(value = "valor produto", example = "500", required = true)
    private BigDecimal valor;
    @ApiModelProperty(value = "dt. compra", example = "2022-12-28", required = true)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dataCompra;
    @ApiModelProperty(value = "cfp", example = "88371462358", required = true)
    private String cpfCliente;
    private EnderecoRequestDTO endereco;
    private CartaoRequestDTO cartao;

}
