package com.mscompra.compra.controller.v1.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class PedidoResponseDTO {

    private Long id;
    private String email;
    private String nome;
    private Long produto;
    private BigDecimal valor;
    private Date dataCompra;
    private String cpfCliente;
    private EnderecoResponseDTO endereco;
    private CartaoResponseDTO cartao;
}
