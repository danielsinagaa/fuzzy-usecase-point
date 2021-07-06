package com.usecasepoint.entity.enumcons;

import lombok.Getter;

@Getter
public enum EFEnum {
    E1("E1","","", 1.5),
    E2("E2","","",0.5),
    E3("E3", "","",1.0),
    E4("E4","","",0.5),
    E5("E5","","",1.0),
    E6("E6","", "", 2.0),
    E7("E7", "", "", -1.0),
    E8("E8","","",-1.0);

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
