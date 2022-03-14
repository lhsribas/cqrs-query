package br.com.lhsribas.cqrs.domain.usecase;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.domain.gateway.PaymentGateway;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
final class FindPaymentUseCaseImpl implements FindPaymentUseCase {

    @Inject
    private PaymentGateway gateway;

    @Override
    public List<EPayment> findAllPaymentByCustomer(final String customer) {
        return gateway.findAllPaymentByCustomer(customer);
    }
}
