package br.com.lhsribas.cqrs.domain.usecase;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface FindPaymentUseCase {

    List<EPayment> findAllPaymentByCustomer(final String customer);
}
