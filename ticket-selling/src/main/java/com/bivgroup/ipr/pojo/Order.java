package com.bivgroup.ipr.pojo;

import com.bivgroup.ipr.pojo.dto.CreateOrderDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс формирования заказа на покупку билета
 */
@Entity
@Table(name = "order")
@SequenceGenerator(name = "order_generator", sequenceName = "ict_order_seq")
public class Order implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_generator")
    private Long id;

    /**
     * Дата создания
     */
    @Column(name = "createdate")
    private LocalDateTime createDate;

    /**
     * Дата редактирования
     */
    @Column(name = "updatedate")
    private LocalDateTime updateDate;

    /**
     * Торговая площадка
     */
    @ManyToOne(targetEntity = TradingFloor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "tradingfloorid")
    private TradingFloor tradingFloor;

    /**
     * Мероприятие
     */
    @ManyToOne(targetEntity = Event.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "eventid")
    private Event event;

    /**
     * Билет
     */
    @ManyToOne(targetEntity = Ticket.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketid")
    private Ticket ticket;

    /**
     * Способ оплаты
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "paymenttype")
    private PaymentType paymentType;

    /**
     * Имя
     */
    @Column(name = "firstname")
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "secondname")
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Телефон
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Емэйл
     */
    @Column(name = "email")
    private String email;

    public Order() {
    }

    public Order(Long id, LocalDateTime createDate, LocalDateTime updateDate, Long tradingFloor, Long event, Long ticket, String paymentType, String firstName, String secondName, String patronymic, String phone, String email) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        if (tradingFloor != null) this.tradingFloor = new TradingFloor(tradingFloor);
        if (ticket != null) this.ticket = new Ticket(ticket);
        if (event != null) this.event = new Event(event);
        this.paymentType = paymentType != null ? PaymentType.getEnumFromValue(paymentType) : PaymentType.CASH;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
    }

    public Order(CreateOrderDTO dto) {
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
        this.paymentType = PaymentType.valueOf(dto.getPaymentType());
        this.firstName = dto.getFirstName();
        this.secondName = dto.getSecondName();
        this.patronymic = dto.getPatronymic();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(createDate, order.createDate) && Objects.equals(updateDate, order.updateDate) && Objects.equals(tradingFloor, order.tradingFloor) && Objects.equals(ticket, order.ticket) && Objects.equals(paymentType, order.paymentType) && Objects.equals(firstName, order.firstName) && Objects.equals(secondName, order.secondName) && Objects.equals(patronymic, order.patronymic) && Objects.equals(phone, order.phone) && Objects.equals(email, order.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate, updateDate, tradingFloor, ticket, paymentType, firstName, secondName, patronymic, phone, email);
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

    public TradingFloor getTradingFloor() {
        return tradingFloor;
    }

    public void setTradingFloor(TradingFloor tradingFloor) {
        this.tradingFloor = tradingFloor;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
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