package com.usecasepoint.controller;

import com.usecasepoint.entity.EF;
import com.usecasepoint.entity.TCF;
import com.usecasepoint.model.ChangeValue;
import com.usecasepoint.service.EFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ef")
@RestController
public class EFController {
    @Autowired
    private EFService service;

    @GetMapping
    public List<EF> getAll(){
        return service.findAll();
    }

    @PatchMapping("/{id}")
    public EF updateValue(@PathVariable String id, @RequestBody ChangeValue value){
        service.changeValue(id, value.getValue());

        return service.findById(id);
    }
}
