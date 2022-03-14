package br.com.lhsribas.cqrs.app.mapper;

import br.com.lhsribas.cqrs.app.dto.PaymentResponse;
import br.com.lhsribas.cqrs.domain.entity.EPayment;

import java.util.Objects;


public class PaymentResponseMapper {

    public static PaymentResponse toResponse(EPayment ePayment){
        Objects.nonNull(ePayment);

        var response = new PaymentResponse();
        response.setCustomer(ePayment.getCustomer());
        response.setId(ePayment.getId());
        response.setDate(ePayment.getDate());
        response.setLatitude(ePayment.getLatitude());
        response.setLongitude(ePayment.getLongitude());
        response.setProduct(ePayment.getProduct());
        response.setValue(ePayment.getValue());

        return response;
    }
}
