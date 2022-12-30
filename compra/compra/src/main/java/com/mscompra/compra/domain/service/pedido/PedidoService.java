package com.mscompra.compra.domain.service.pedido;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mscompra.compra.api.restClient.ApiCep;
import com.mscompra.compra.domain.model.Pedido;
import com.mscompra.compra.domain.repository.PedidoRepository;
import com.mscompra.compra.domain.service.rabbitmq.PedidoProducerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private final PedidoProducerService producer;

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private ApiCep apiCep;

    public PedidoService(PedidoProducerService producer, PedidoRepository pedidoRepository) {
        this.producer = producer;
        this.pedidoRepository = pedidoRepository;
    }

    @SneakyThrows
    public Pedido salvar(Pedido pedido) {
        ObjectMapper objectMapper = new ObjectMapper();
        var pedidoSalvo =  pedidoRepository.save(apiCep.request(pedido));
        producer.sendMessage(objectMapper.writeValueAsString(pedidoSalvo));
        return pedidoSalvo;

    }
}
