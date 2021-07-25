package com.usecasepoint.model;

import com.usecasepoint.entity.Metrics;
import lombok.Data;

@Data
public class MetricsShow {

    private String nama;

    private Integer actual;

    private Integer effortUCP;

    private Integer effortFUCP;

    private Double merUCP;

    private Double merFUCP;

    private Double mreUCP;

    private Double mreFUCP;

    private Integer errorUCP;

    private Integer errorFUCP;

    public MetricsShow(Metrics metrics) {
        this.nama = metrics.getNama();
        this.actual = metrics.getActual().intValue();
        this.effortUCP = metrics.getEffortUCP().intValue();
        this.effortFUCP = metrics.getEffortFUCP().intValue();
        this.merUCP = metrics.getMerUCP();
        this.merFUCP = metrics.getMerFUCP();
        this.mreUCP = metrics.getMreUCP();
        this.mreFUCP = metrics.getMreFUCP();
        this.errorUCP = metrics.getErrorUCP().intValue();
        this.errorFUCP = metrics.getErrorFUCP().intValue()
        ;
    }
}
