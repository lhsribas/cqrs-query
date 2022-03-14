package br.com.lhsribas.cqrs.infra.cache.repository;

import br.com.lhsribas.cqrs.infra.cache.PaymentCacheFactory;
import br.com.lhsribas.cqrs.infra.cache.PaymentJsonRead;
import br.com.lhsribas.cqrs.infra.cache.model.Payment;
import br.com.lhsribas.cqrs.infra.mapper.PaymentMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.redis.client.Response;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PaymentRepository {

    private static final Logger LOG = Logger.getLogger(PaymentRepository.class);

    @Inject
    private PaymentCacheFactory factory;

    public List<Payment> findAllPaymentByCustomer(final String customer){
        return factory.findAllPaymentByCustomer(customer);
    }

}
