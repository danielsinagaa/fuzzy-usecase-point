package com.usecasepoint.controller;

import com.usecasepoint.entity.Proyek;
import com.usecasepoint.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/proyek")
@RestController
public class ProyekController {
    @Autowired
    private ProyekService service;

    @PostMapping
    public Proyek add(@RequestBody Proyek proyek){
        return service.save(proyek);
    }

    @GetMapping
    public List<Proyek> getAll(){
        return service.findAll();
    }
}
