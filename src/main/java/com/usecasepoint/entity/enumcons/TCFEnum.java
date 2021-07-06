package com.usecasepoint.entity.enumcons;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TCFEnum {
    T1("T1","Distributed System", "sistem yang digunakan oleh perusahaan untuk mendistribusikan produk atau jasa kepada para pelanggannya", 2.0),
    T2("T2", "Response Time Or Throughput Performance Objective", "Target dan sasaran waktu untuk merespon kinerja dan hasil saat memproses beban kerja yang ditentukan. ", 1.0),
    T3("T3", "End-User Online Efficiency ", "Efisiensi waktu yang digunakan oleh user ketika aktif/online menggunakan produk", 1.0),
    T4("T4", "Complex Internal Processing", "Kompleksitas dari internal pengembang/developer dalam memproses produk", 1.0),
    T5("T5", "Reusability Of Code", "", 1.0),
    T6("T6","","",0.5),
    T7("T7","","", 0.5),
    T8("T8","","",2.0),
    T9("T9", "", "", 1.0),
    T10("T10","","",1.0),
    T11("T11","","",1.0),
    T12("T12","","",1.0),
    T13("T13","","",1.0);

    TCFEnum(String code, String deskripsi, String uraian, Double bobot) {
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
