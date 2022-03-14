package br.com.lhsribas.cqrs.infra.cache;

import br.com.lhsribas.cqrs.infra.cache.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentJsonRead {

    public static Payment read(final String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Payment.class);
    }
}
