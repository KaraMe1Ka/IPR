package com.bivgroup.ipr.pojo;

import com.bivgroup.ipr.pojo.dto.EventDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Мероприятие
 */
@Entity
@Table(name = "event")
@SequenceGenerator(name = "event_generator", sequenceName = "ict_event_seq")
public class Event implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_generator")
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

    public Event() {
    }

    public Event(Long id, String name, String brief) {
        this.id = id;
        this.name = name;
        this.brief = brief;
    }

    public Event(EventDTO dto) {
        this.name = dto.getName();
        this.brief = dto.getBrief();
    }

    public Event(Long event) {
        this.id = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(name, event.name) && Objects.equals(brief, event.brief);
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