package br.com.lhsribas.cqrs.infra.mapper;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.infra.cache.model.Payment;

import java.util.Objects;

public class PaymentMapper {

    public static Payment toModel(EPayment ePayment){
        Objects.nonNull(ePayment);

        var payment = new Payment();
        payment.setCustomer(ePayment.getCustomer());
        payment.setProduct(ePayment.getProduct());
        payment.setDate(ePayment.getDate());
        payment.setLatitude(ePayment.getLatitude());
        payment.setLongitude(ePayment.getLongitude());
        payment.setValue(ePayment.getValue());

        return payment;
    }

    public static EPayment toEntity(Payment payment){
        Objects.nonNull(payment);

        var ePayment = new EPayment();
        ePayment.setCustomer(payment.getCustomer());
        ePayment.setId(payment.getId());
        ePayment.setProduct(payment.getProduct());
        ePayment.setDate(payment.getDate());
        ePayment.setLatitude(payment.getLatitude());
        ePayment.setLongitude(payment.getLongitude());
        ePayment.setValue(payment.getValue());

        return ePayment;
    }
}
