package br.com.lhsribas.cqrs.app.service;

import br.com.lhsribas.cqrs.app.dto.PaymentResponse;
import br.com.lhsribas.cqrs.app.mapper.PaymentResponseMapper;
import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.domain.usecase.FindPaymentUseCase;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PaymentCacheService {

    @Inject
    private FindPaymentUseCase findPaymentUseCase;

    public List<PaymentResponse> findAllPaymentByCustomer(final String customer){

        List<PaymentResponse> data = new ArrayList<>();

        findPaymentUseCase.findAllPaymentByCustomer(customer).forEach(ep -> {
            data.add(PaymentResponseMapper.toResponse(ep));
        });

        return data;
    }

}
