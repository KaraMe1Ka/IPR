package com.bivgroup.ipr.pojo.dto;

import com.bivgroup.ipr.pojo.Order;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Создать заказ")
public class CreateOrderDTO {

    @Schema(description = "Торговая площадка")
    public Long tradingFloor;

    @Schema(description = "Торговая площадка")
    public Long event;

    @Schema(description = "Билет")
    public Long ticket;

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

    public CreateOrderDTO() {
    }

    public Long getTradingFloor() {
        return tradingFloor;
    }

    public void setTradingFloor(Long tradingFloor) {
        this.tradingFloor = tradingFloor;
    }

    public Long getEvent() {
        return event;
    }

    public void setEvent(Long event) {
        this.event = event;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
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