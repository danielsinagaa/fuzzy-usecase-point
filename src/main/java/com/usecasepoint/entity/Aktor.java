package com.usecasepoint.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter @Setter
@Table
@Entity
public class Aktor extends IdTable{
    @Column(nullable = false)
    private String nama;

    @Column(nullable = false)
    private String kategori;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Proyek proyek;

    public Aktor(String nama, String kategori, Proyek proyek) {
        this.nama = nama;
        this.kategori = kategori;
        this.proyek = proyek;
    }

    public Aktor() {
    }
}
