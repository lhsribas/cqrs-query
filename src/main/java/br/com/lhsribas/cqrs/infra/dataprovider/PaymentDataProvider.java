package br.com.lhsribas.cqrs.infra.dataprovider;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.domain.gateway.PaymentGateway;
import br.com.lhsribas.cqrs.infra.cache.model.Payment;
import br.com.lhsribas.cqrs.infra.cache.repository.PaymentRepository;
import br.com.lhsribas.cqrs.infra.mapper.PaymentMapper;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
final class PaymentDataProvider implements PaymentGateway {

    @Inject
    private PaymentRepository repository;

    @Override
    public List<EPayment> findAllPaymentByCustomer(final String customer) {

        List<EPayment> data = new ArrayList<>();

        repository.findAllPaymentByCustomer(customer).forEach(p -> {
            data.add(PaymentMapper.toEntity(p));
        });

        return data;
    }
}
