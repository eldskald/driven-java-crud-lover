package com.crudlover.api.models;

import java.util.Date;

import com.crudlover.api.dtos.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

    public Car(CarDTO dto) {
        this.modelo = dto.modelo();
        this.fabricante = dto.fabricante();
        this.dataFabricacao = dto.dataFabricacao();
        this.valor = dto.valor();
        this.anoModelo = dto.anoModelo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String modelo;

    @Column(length = 50, nullable = false)
    private String fabricante;

    @Column(length = 50, nullable = false)
    private Date dataFabricacao;

    @Column()
    private int valor;

    @Column()
    private int anoModelo;
}