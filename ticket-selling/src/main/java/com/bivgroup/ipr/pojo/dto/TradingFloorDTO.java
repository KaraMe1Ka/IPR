package com.bivgroup.ipr.pojo.dto;

import com.bivgroup.ipr.pojo.TradingFloor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Торговая площадка")
public class TradingFloorDTO {

    @Schema(description = "наименование")
    public String name;

    @Schema(description = "сокращение")
    public String brief;

    public TradingFloorDTO(TradingFloor tradingFloor) {
        this.name = tradingFloor.getName();
        this.brief = tradingFloor.getBrief();
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