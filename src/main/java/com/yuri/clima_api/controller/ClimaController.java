package com.yuri.clima_api.controller;


import com.yuri.clima_api.dto.ClimaDTO;
import com.yuri.clima_api.entity.ConsultaClima;
import com.yuri.clima_api.service.ClimaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClimaController {

    private final ClimaService climaService;

    @Autowired
    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }


    @GetMapping("/consultar")
    public ResponseEntity<ClimaDTO> consultarClima(@RequestParam String country, @RequestParam String token) {
        ClimaDTO clima = climaService.buscarClima(country, token);
        return ResponseEntity.ok(clima);
    }
}