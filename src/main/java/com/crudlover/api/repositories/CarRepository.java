package com.crudlover.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudlover.api.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {}
