package com.mscompra.compra.controller.v1.mapper;


import com.mscompra.compra.controller.v1.dto.PedidoRequestDTO;
import com.mscompra.compra.controller.v1.dto.PedidoResponseDTO;
import com.mscompra.compra.domain.model.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    Pedido toPedido(PedidoRequestDTO pedido);
    PedidoResponseDTO toPedidoResponseDTO(Pedido pedido);
}
