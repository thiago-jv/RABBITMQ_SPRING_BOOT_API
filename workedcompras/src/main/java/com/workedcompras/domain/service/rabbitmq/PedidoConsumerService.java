package com.workedcompras.domain.service.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workedcompras.domain.model.Pedido;
import com.workedcompras.domain.service.PedidoService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PedidoConsumerService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PedidoService pedidoService;

    @SneakyThrows
    @RabbitListener(queues = {"${rabbitmq.queue.name-efetuada}"})
    public void consumer(@Payload Message payload) {
        var pedido = objectMapper.readValue(payload.getBody(), Pedido.class);
        log.info("Payload recebido do compra " + pedido);
        pedidoService.sendPedido(pedido);
        log.info("Payload enviado para o validator " + pedido);

    }
}
