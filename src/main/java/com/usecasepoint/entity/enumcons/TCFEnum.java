package com.usecasepoint.entity.enumcons;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TCFEnum {
    T1("T1","Distributed System", "sistem yang digunakan oleh perusahaan untuk mendistribusikan produk atau jasa kepada para pelanggannya", 2.0),
    T2("T2", "Response Time Or Throughput Performance Objective", "Target dan sasaran waktu untuk merespon kinerja dan hasil saat memproses beban kerja yang ditentukan. ", 1.0),
    T3("T3", "End-User Online Efficiency ", "Efisiensi waktu yang digunakan oleh user ketika aktif/online menggunakan produk", 1.0),
    T4("T4", "Complex Internal Processing", "Kompleksitas dari internal pengembang/developer dalam memproses produk", 1.0),
    T5("T5", "Reusability Of Code", "Penggunaan code yang dapat digunakan kembali dalam pembaharuan versi atau pengembangan software yang baru menggunakan aset yang sudah ada sebelumnya.", 1.0),
    T6("T6","Easy To Install","Produk data diunduh secara mudah oleh user",0.5),
    T7("T7","Ease of Use","Produk dapat digunakan dengan mudah dan cepat dipahami oleh user", 0.5),
    T8("T8","Portability","Kemudahaan yang sama bagi user dalam penggunaan produk dari lingkungan yang berbeda",2.0),
    T9("T9", "Ease of Change", "Perubahan yang mudah dan cepat mengikuti kebutuhan pasar", 1.0),
    T10("T10","Concurrency ","Permintaan user yang bisa dilaksanakan dalam sekaligus atau satu waktu",1.0),
    T11("T11","Special Security Objectives Included","Keamaan aplikasi bagi user ",1.0),
    T12("T12","Direct Access For Third Parties ","Akses langsung pihak ketiga yang berkerjasama dengan produk",1.0),
    T13("T13","Special User Training Required","Pelatihan khusus atau petunjuk khusus bagi user dalam menggunakan produk",1.0);

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
