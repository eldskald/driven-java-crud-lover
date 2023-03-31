package com.crudlover.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.dtos.CarDTO;
import com.crudlover.api.repositories.CarRepository;

import jakarta.validation.Valid;

import com.crudlover.api.models.Car;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid CarDTO body) {
        repository.save(new Car(body));
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody @Valid CarDTO body
    ) {
        repository.findById(id).map(car -> {
            car.setModelo(body.modelo());
            car.setFabricante(body.fabricante());
            car.setDataFabricacao(body.dataFabricacao());
            car.setValor(body.valor());
            car.setAnoModelo(body.anoModelo());
            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
