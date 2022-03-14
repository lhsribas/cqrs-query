package br.com.lhsribas.cqrs.domain.gateway;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface PaymentGateway {

    List<EPayment> findAllPaymentByCustomer(final String customer);

}
