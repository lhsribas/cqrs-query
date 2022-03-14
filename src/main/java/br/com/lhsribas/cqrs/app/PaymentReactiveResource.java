package br.com.lhsribas.cqrs.app;

import br.com.lhsribas.cqrs.app.dto.PaymentResponse;
import br.com.lhsribas.cqrs.app.service.PaymentCacheService;
import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@RouteBase(path = "/reactPayments", produces = MediaType.APPLICATION_JSON)
public class PaymentReactiveResource {

    @Inject
    private PaymentCacheService service;

    @Route(path = "/findByCustomer", methods = Route.HttpMethod.GET)
    @Blocking
    Uni<List<PaymentResponse>> findAllPaymentByCustomer(@Param("customer") final String customer){
        return Uni.createFrom().item(() -> service.findAllPaymentByCustomer(customer));
    }
}
