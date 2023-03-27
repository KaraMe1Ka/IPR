package com.bivgroup.ipr.pojo.dto;

import com.bivgroup.ipr.pojo.Order;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Заказ")
public class OrderDTO {

    @Schema(description = "идентификатор")
    public Long id;

    @Schema(description = "дата создания")
    public LocalDateTime createDate;

    @Schema(description = "дата редактирования")
    public LocalDateTime updateDate;

    @Schema(description = "Торговая площадка")
    public TradingFloorDTO tradingFloor;

    @Schema(description = "Торговая площадка")
    public EventDTO event;

    @Schema(description = "Билет")
    public TicketDTO ticket;

    @Schema(description = "Способ оплаты")
    public String paymentType;

    @Schema(description = "Имя")
    public String firstName;

    @Schema(description = "Фамилия")
    public String secondName;

    @Schema(description = "Отчество")
    public String patronymic;

    @Schema(description = "Телефон")
    public String phone;

    @Schema(description = "Емэйл")
    public String email;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.createDate = order.getCreateDate();
        this.updateDate = order.getUpdateDate();
        if (order.getTradingFloor() != null) this.tradingFloor = new TradingFloorDTO(order.getTradingFloor());
        if (order.getEvent() != null) this.event = new EventDTO(order.getEvent());
        if (order.getTicket() != null) this.ticket = new TicketDTO(order.getTicket());
        this.paymentType = order.getPaymentType().getPaymentType();
        this.firstName = order.getFirstName();
        this.secondName = order.getSecondName();
        this.patronymic = order.getPatronymic();
        this.phone = order.getPhone();
        this.email = order.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public TradingFloorDTO getTradingFloor() {
        return tradingFloor;
    }

    public void setTradingFloor(TradingFloorDTO tradingFloor) {
        this.tradingFloor = tradingFloor;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public TicketDTO getTicket() {
        return ticket;
    }

    public void setTicket(TicketDTO ticket) {
        this.ticket = ticket;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}