package com.usecasepoint.controller;

import com.usecasepoint.entity.UseCase;
import com.usecasepoint.model.UseCaseRequest;
import com.usecasepoint.service.UseCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usecase")
@RestController
public class UseCaseController {
    @Autowired
    private UseCaseService service;

    @PostMapping
    public UseCase save(@RequestBody UseCaseRequest request){
        return service.save(request);
    }

    @GetMapping
    public List<UseCase> getAll(){
        return service.findAll();
    }
}
