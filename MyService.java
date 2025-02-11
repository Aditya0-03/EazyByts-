package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MyRepository;
import com.example.demo.model.MyEntity;

import java.util.List;

@Service
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    // Fetch all data from DB
    public List<MyEntity> getAllData() {
        return myRepository.findAll();
    }

    // Add new data
    public MyEntity saveData(MyEntity entity) {
        return myRepository.save(entity);
    }
}
