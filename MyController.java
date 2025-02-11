package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.MyService;
import com.example.demo.model.MyEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    // Get all data
    @GetMapping("/data")
    public List<MyEntity> getAllData() {
        return myService.getAllData();
    }

    // Add new data
    @PostMapping("/data")
    public MyEntity saveData(@RequestBody MyEntity entity) {
        return myService.saveData(entity);
    }
}
