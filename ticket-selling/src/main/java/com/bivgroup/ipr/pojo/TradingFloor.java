package com.bivgroup.ipr.pojo;

import com.bivgroup.ipr.pojo.dto.TradingFloorDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Торговая площадка
 */
@Entity
@Table(name = "tradingfloor")
@SequenceGenerator(name = "tradingfloor_generator", sequenceName = "ict_tradingfloor_seq")
public class TradingFloor implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tradingfloor_generator")
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

    public TradingFloor() {
    }

    public TradingFloor(Long id, String name, String brief) {
        this.id = id;
        this.name = name;
        this.brief = brief;
    }

    public TradingFloor(TradingFloorDTO dto) {
        this.name = dto.getName();
        this.brief = dto.getBrief();
    }

    public TradingFloor(Long tradingFloor) {
        this.id = tradingFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradingFloor that = (TradingFloor) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(brief, that.brief);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brief);
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
}