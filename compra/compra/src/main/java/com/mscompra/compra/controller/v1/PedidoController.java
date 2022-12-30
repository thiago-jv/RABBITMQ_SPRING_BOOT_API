package com.mscompra.compra.controller.v1;

import com.mscompra.compra.controller.v1.dto.PedidoRequestDTO;
import com.mscompra.compra.controller.v1.dto.PedidoResponseDTO;
import com.mscompra.compra.controller.v1.mapper.PedidoMapper;
import com.mscompra.compra.domain.model.Pedido;
import com.mscompra.compra.domain.service.pedido.PedidoService;
import com.mscompra.compra.domain.service.rabbitmq.PedidoProducerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "Compras")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private final PedidoMapper pedidoMapper;

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService, PedidoProducerService producer, PedidoMapper pedidoMapper) {
        this.pedidoService = pedidoService;
        this.pedidoMapper = pedidoMapper;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> salvar(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO) {
        return  ResponseEntity.ok(pedidoMapper.toPedidoResponseDTO(pedidoService.salvar(pedidoMapper.toPedido(pedidoRequestDTO))));
    }

}
