package com.example.ApiMoneda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiMoneda.entity.Moneda;
import com.example.ApiMoneda.entity.MonedaId;

public interface MonedaDao extends JpaRepository<Moneda, MonedaId> {

}
