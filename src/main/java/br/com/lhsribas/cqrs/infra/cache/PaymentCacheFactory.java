package br.com.lhsribas.cqrs.infra.cache;

import br.com.lhsribas.cqrs.infra.cache.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.redis.client.Response;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReferenceArray;

@Singleton
public class PaymentCacheFactory {

    @Inject
    RedisClient redisClient;

    @Inject
    ReactiveRedisClient reactiveRedisClient;

    public List<Payment> findAllPaymentByCustomer(final String customer){
        List<Payment> data = new ArrayList<>();

        for (String s : getKeysByCustomer(customer)){
            try {
                data.add(PaymentJsonRead.read(redisClient.get(s)
                        .toString()
                        .replaceAll("\n", "")
                        .replaceAll("\'", "\"")));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    private List<String> getKeysByCustomer(final String customer){
       List<String> keys = new ArrayList<>();

       var index = redisClient.keys(customer.concat("*")).size();

       for(int a=0; a<index; a++){
           keys.add(String.valueOf(redisClient.keys(customer.concat("*")).get(a)));
       }
       return keys;
    }

}
