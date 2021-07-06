package com.usecasepoint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@Getter @Setter
public class Metrics extends IdTable{
    @Column(nullable = false)
    private String nama;
    @Column(nullable = false)
    private Double actual;
    @Column
    private Double effortUCP = 0.0;
    @Column
    private Double effortFUCP = 0.0;
    @Column
    private Double merUCP = 0.0;
    @Column
    private Double merFUCP = 0.0;
    @Column
    private Double mreUCP = 0.0;
    @Column
    private Double mreFUCP = 0.0;
    @Column
    private Double errorUCP = 0.0;
    @Column
    private Double errorFUCP = 0.0;

    public Metrics(String nama, Double actual) {
        this.nama = nama;
        this.actual = actual;
    }

    public Metrics() {
    }
}
