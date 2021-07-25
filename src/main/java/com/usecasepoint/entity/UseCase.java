package com.usecasepoint.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
public class UseCase extends IdTable{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer jumlahTransaksi;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Proyek proyek;

    public UseCase(String name, Integer jumlahTransaksi, Proyek proyek) {
        this.name = name;
        this.jumlahTransaksi = jumlahTransaksi;
        this.proyek = proyek;
    }

    public UseCase() {
    }
}
