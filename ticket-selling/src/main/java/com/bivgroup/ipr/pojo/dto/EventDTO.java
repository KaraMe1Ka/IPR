package com.bivgroup.ipr.pojo.dto;

import com.bivgroup.ipr.pojo.Event;
import com.bivgroup.ipr.pojo.TradingFloor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Мероприятие")
public class EventDTO {

    @Schema(description = "наименование")
    public String name;

    @Schema(description = "сокращение")
    public String brief;

    public EventDTO(Event event) {
        this.name = event.getName();
        this.brief = event.getBrief();
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
}