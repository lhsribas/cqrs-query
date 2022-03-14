package br.com.lhsribas.cqrs.app;

import br.com.lhsribas.cqrs.app.dto.PaymentResponse;
import br.com.lhsribas.cqrs.app.service.PaymentCacheService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payments")
public class PaymentResource {

    @Inject
    private PaymentCacheService service;

    @GET
    @Path("/ping")
    public Response ping(){
        return Response.status(200).entity("pong").build();
    }

    @GET
    @Path("/findAllPaymentByCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPaymentByCustomer(){
        return  Response.ok(service.findAllPaymentByCustomer("lhsribas")).build();
    }

}
