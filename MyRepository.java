package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.MyEntity;

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
}
