package com.usecasepoint.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class EF extends IdTable{
    @Column(nullable = false)
    private String code;

    @Column
    private Double value;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Proyek proyek;

    public EF(String code, Proyek proyek) {
        this.code = code;
        this.proyek = proyek;
    }

    public EF() {
    }
}
