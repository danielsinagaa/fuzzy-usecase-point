package com.usecasepoint.controller;

import com.usecasepoint.entity.Metrics;
import com.usecasepoint.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/metrics")
@RestController
public class MetricController {
    @Autowired
    private MetricService service;

    @GetMapping
    public List<Metrics> getAll(){
        return service.findAll();
    }
}
