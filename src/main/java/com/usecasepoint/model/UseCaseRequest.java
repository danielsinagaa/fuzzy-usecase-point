package com.usecasepoint.model;

import com.usecasepoint.entity.Proyek;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UseCaseRequest {
    private String name;
    private Integer jumlahTransaksi;
    private String proyekId;
}
