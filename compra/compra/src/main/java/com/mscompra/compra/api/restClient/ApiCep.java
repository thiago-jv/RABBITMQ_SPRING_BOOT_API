package com.mscompra.compra.api.restClient;

import com.mscompra.compra.api.exceptionhandler.CepNaoEncontadoException;
import com.mscompra.compra.controller.v1.dto.EnderecoResponseDTO;
import com.mscompra.compra.domain.model.Endereco;
import com.mscompra.compra.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class ApiCep {

    @Value("${uri.cep}")
    private String uri;
    public Pedido request(Pedido pedido) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            var responseEndereco = restTemplate.getForObject(uri, EnderecoResponseDTO.class, pedido.getEndereco().getCep());
            if (Objects.nonNull(responseEndereco)) {
                var endereco = new Endereco();
                endereco.setCep(responseEndereco.getCep());
                endereco.setLogradouro(responseEndereco.getLogradouro());
                endereco.setComplemento(responseEndereco.getComplemento());
                endereco.setBairro(responseEndereco.getBairro());
                endereco.setUf(responseEndereco.getUf());
                endereco.setLocalidade(responseEndereco.getLocalidade());
                pedido.setEndereco(endereco);
                return pedido;
            }
        } catch (RestClientException e) {
            throw new CepNaoEncontadoException();
        }
        return pedido;
    }
}

