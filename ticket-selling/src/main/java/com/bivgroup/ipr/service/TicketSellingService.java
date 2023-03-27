package com.bivgroup.ipr.service;

import com.bivgroup.ipr.pojo.Event;
import com.bivgroup.ipr.pojo.Order;
import com.bivgroup.ipr.pojo.Ticket;
import com.bivgroup.ipr.pojo.TradingFloor;
import com.bivgroup.ipr.pojo.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис продажи билетов
 */
@ApplicationScoped
public class TicketSellingService {

    private static final Logger logger = LoggerFactory.getLogger(TicketSellingService.class.getName());

    @Inject
    EntityManager entityManager;

    public List<OrderDTO> getAllOrders() {
        return entityManager.createQuery("select o from order o", Order.class)
                .getResultList()
                .stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = entityManager.find(Order.class, id);
        if (order == null) {
            throw new RuntimeException("order not found with id = " + id);
        }
        return new OrderDTO(order);
    }

    @Transactional(rollbackOn = {Exception.class})
    public void createOrder(CreateOrderDTO createOrderDTO) {
        Order order = new Order(createOrderDTO);
        order.setTradingFloor(entityManager.find(TradingFloor.class, createOrderDTO.getTradingFloor()));
        order.setEvent(entityManager.find(Event.class, createOrderDTO.getEvent()));
        order.setTicket(entityManager.find(Ticket.class, createOrderDTO.getTicket()));
        entityManager.persist(order);
    }

    public List<TicketDTO> getAllTickets() {
        return entityManager.createQuery("select t from ticket t", Ticket.class)
                .getResultList()
                .stream().map(TicketDTO::new).collect(Collectors.toList());
    }

    public TicketDTO getTicketById(Long id) {
        Ticket ticket = entityManager.find(Ticket.class, id);
        if (ticket == null) {
            throw new RuntimeException("ticket not found with id = " + id);
        }
        return new TicketDTO(ticket);
    }

    public List<EventDTO> getAllEvents() {
        return entityManager.createQuery("select e from event e", Event.class)
                .getResultList()
                .stream().map(EventDTO::new).collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        Event event = entityManager.find(Event.class, id);
        if (event == null) {
            throw new RuntimeException("event not found with id = " + id);
        }
        return new EventDTO(event);
    }

    public List<TradingFloorDTO> getAllTradingFloors() {
        return entityManager.createQuery("select t from tradingfloor t", TradingFloor.class)
                .getResultList()
                .stream().map(TradingFloorDTO::new).collect(Collectors.toList());
    }

    public TradingFloorDTO getTradingFloorById(Long id) {
        TradingFloor tradingFloor = entityManager.find(TradingFloor.class, id);
        if (tradingFloor == null) {
            throw new RuntimeException("tradingFloor not found with id = " + id);
        }
        return new TradingFloorDTO(tradingFloor);
    }
}