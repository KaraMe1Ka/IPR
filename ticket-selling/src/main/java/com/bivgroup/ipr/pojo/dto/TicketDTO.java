package com.bivgroup.ipr.pojo.dto;

import com.bivgroup.ipr.pojo.Event;
import com.bivgroup.ipr.pojo.Ticket;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Билет")
public class TicketDTO {

    @Schema(description = "наименование")
    public String name;

    @Schema(description = "сокращение")
    public String brief;

    @Schema(description = "Стоимость")
    public String price;

    @Schema(description = "Наличие билета")
    public Boolean isSales;

    public TicketDTO(Ticket ticket) {
        this.name = ticket.getName();
        this.brief = ticket.getBrief();
        this.price = ticket.getPrice();
        this.isSales = ticket.getSales();
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