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
public class Proyek extends IdTable{
    @Column(nullable = false)
    private String nama;
    @Column(nullable = false)
    private Integer jumlahAktor;
    @Column(nullable = false)
    private Integer jumlahUseCase;
    @Column(nullable = false)
    private Integer effort;
    @JoinColumn
    @OneToOne
    private Metrics metrics;
}
