package com.workedcompras.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workedcompras.domain.model.Pedido;
import com.workedcompras.domain.service.rabbitmq.PedidoProducerService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PedidoService {

    @Autowired
    private PedidoProducerService pedidoProducer;

    @SneakyThrows
    public void sendPedido(Pedido pedido) {
        ObjectMapper objectMapper = new ObjectMapper();
        pedidoProducer.sendMessage(objectMapper.writeValueAsString(pedido));
        log.info("Pedido montado com sucesso em Worker Compras - Pedido: " , pedido);
    }
}
