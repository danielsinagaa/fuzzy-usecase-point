package com.usecasepoint.entity.enumcons;

import lombok.Getter;

@Getter
public enum EFEnum {
    E1("E1","Familiarity with system development process being used","pemahaman dengan proses pengembangan sistem yang digunakan", 1.5),
    E2("E2","Application experience","experience yang diperoleh user pada saat menggunakan produk",0.5),
    E3("E3", "Object-oriented experience ","Penggunaan oop(obejct oriented programming) pada aplikasi",1.0),
    E4("E4","Lead analyst capability ","Kapabilitas dari analisis sistem pada saat proses pengembangan",0.5),
    E5("E5","Motivation","Motivasi tim dalam mengembangkan produk",1.0),
    E6("E6","Requirements stability", "Stabilitas requirement pada saat pengembangan produk", 2.0),
    E7("E7", "Part time staff", "Pekerja part time yang berada pada tim pengembang produk", -1.0),
    E8("E8","Difficulty of programming language","Kesulitan bahasa pemograman yang digunakan pada saat mengambangkan produk",-1.0);

    EFEnum(String code, String deskripsi, String uraian, Double bobot) {
        this.code = code;
        this.deskripsi = deskripsi;
        this.uraian = uraian;
        this.bobot = bobot;
    }

    private String code;
    private String deskripsi;
    private String uraian;
    private Double bobot;
}
