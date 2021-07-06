package com.usecasepoint.entity;

import com.usecasepoint.entity.enumcons.EFEnum;
import com.usecasepoint.entity.enumcons.TCFEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TCFModel {
    private String id;
    private String code;
    private String technicalFactor;
    private Double multiplier;
    private Double value;
    private String description;

    public TCFModel() {
    }

    public TCFModel(TCFEnum tcfEnum, TCF tcf) {
        id = tcf.getId();
        code = tcfEnum.getCode();
        technicalFactor = tcfEnum.getUraian();
        multiplier = tcfEnum.getBobot();
        description = tcfEnum.getDeskripsi();
        value = tcf.getValue();
    }

    public TCFModel(EFEnum tcfEnum, EF ef) {
        id = ef.getId();
        code = tcfEnum.getCode();
        technicalFactor = tcfEnum.getUraian();
        multiplier = tcfEnum.getBobot();
        description = tcfEnum.getDeskripsi();
        value = ef.getValue();
    }
}
