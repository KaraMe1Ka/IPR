package com.bivgroup.ipr;

import com.bivgroup.ipr.pojo.dto.*;
import com.bivgroup.ipr.service.TicketSellingService;
import com.oracle.svm.core.annotate.Inject;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ticket-selling")
@Tag(name = "Сервис продажи билетов")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SellingResource {

    @Inject
    TicketSellingService ticketSellingService;

    @GET
    @Path("/getAllOrders")
    @Operation(description = "Получить все заказы")
    public List<OrderDTO> getAllOrders() {
        return ticketSellingService.getAllOrders();
    }

    @GET
    @Path("/getOrderById/{id}")
    @Operation(description = "Получить заказ по ид")
    public OrderDTO getOrderById(@PathParam("id") Long id) {
        return ticketSellingService.getOrderById(id);
    }

    @POST
    @Path("/createOrder")
    @Operation(description = "Создать заказ")
    public String createOrder(CreateOrderDTO dto) {
        ticketSellingService.createOrder(dto);
        return "OK";
    }

    @GET
    @Path("/getAllEvents")
    @Operation(description = "Получить все мероприятия")
    public List<EventDTO> getAllEvents() {
        return ticketSellingService.getAllEvents();
    }

    @GET
    @Path("/getEventById/{id}")
    @Operation(description = "Получить заказ по ид")
    public EventDTO getEventById(@PathParam("id") Long id) {
        return ticketSellingService.getEventById(id);
    }

    @GET
    @Path("/getAllTickets")
    @Operation(description = "Получить все билеты")
    public List<TicketDTO> getAllTickets() {
        return ticketSellingService.getAllTickets();
    }

    @GET
    @Path("/getTicketById/{id}")
    @Operation(description = "Получить заказ по ид")
    public TicketDTO getTicketById(@PathParam("id") Long id) {
        return ticketSellingService.getTicketById(id);
    }

    @GET
    @Path("/getAllTradingFloors")
    @Operation(description = "Получить все торговые плозадки")
    public List<TradingFloorDTO> getAllTradingFloors() {
        return ticketSellingService.getAllTradingFloors();
    }

    @GET
    @Path("/getTradingFloorById/{id}")
    @Operation(description = "Получить заказ по ид")
    public TradingFloorDTO getTradingFloorById(@PathParam("id") Long id) {
        return ticketSellingService.getTradingFloorById(id);
    }
}