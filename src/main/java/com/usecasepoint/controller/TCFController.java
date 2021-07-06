package com.usecasepoint.controller;

import com.usecasepoint.entity.TCF;
import com.usecasepoint.model.ChangeValue;
import com.usecasepoint.service.TCFService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tcf")
@RestController
public class TCFController {
    @Autowired
    private TCFService service;

    @GetMapping
    public List<TCF> getAll(){
        return service.findAll();
    }

    @PatchMapping("/{id}")
    public TCF updateValue(@PathVariable(name = "id") String id, @RequestBody ChangeValue value){
        service.changeValue(id, value.getValue());

        return service.findById(id);
    }

}
