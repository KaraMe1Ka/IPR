package com.bivgroup.ipr.pojo;

import com.bivgroup.ipr.pojo.dto.TicketDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Билет
 */
@Entity
@Table(name = "ticket")
@SequenceGenerator(name = "ticket_generator", sequenceName = "ict_ticket_seq")
public class Ticket implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    private Long id;

    /**
     * Наименование
     */
    @Column(name = "name")
    private String name;

    /**
     * Сокращение
     */
    @Column(name = "brief")
    private String brief;

    /**
     * Стоимость
     */
    @Column(name = "price")
    private String price;

    /**
     * Наличие билета
     */
    @Column(name = "issales")
    private Boolean isSales;

    public Ticket() {
    }

    public Ticket(Long id, String name, String brief, String price, Boolean isSales) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.price = price;
        this.isSales = isSales;
    }

    public Ticket(TicketDTO dto) {
        this.name = dto.getName();
        this.brief = dto.getBrief();
        this.price = dto.getPrice();
        this.isSales = dto.getSales();
    }

    public Ticket(Long ticket) {
        this.id = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(name, ticket.name) && Objects.equals(brief, ticket.brief) && Objects.equals(price, ticket.price) && Objects.equals(isSales, ticket.isSales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brief, price, isSales);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getSales() {
        return isSales;
    }

    public void setSales(Boolean sales) {
        isSales = sales;
    }
}