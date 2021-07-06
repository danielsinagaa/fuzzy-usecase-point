package com.usecasepoint.controller;

import com.usecasepoint.entity.Aktor;
import com.usecasepoint.exception.BadRequestEx;
import com.usecasepoint.model.AktorRequest;
import com.usecasepoint.service.AktorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/aktor")
@RestController
public class AktorController {
    @Autowired
    private AktorService service;

    @PostMapping
    public Aktor add(@RequestBody AktorRequest aktor) {
        if (!aktor.getKategori().equals("simple") && !aktor.getKategori().equals("complex") && !aktor.getKategori().equals("average") ){
            throw new BadRequestEx();
        }
        return service.save(aktor);
    }

    @GetMapping
    public List<Aktor> getAll(){
        return service.findAll();
    }
}
