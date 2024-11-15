package com.yuri.clima_api.controller;

import com.yuri.clima_api.dto.ClimaDTO;
import com.yuri.clima_api.service.ClimaService;
import com.yuri.clima_api.entity.ConsultaClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping("/{cidade}")
    public ClimaDTO buscarClima(@PathVariable String cidade) {
        return climaService.buscarClima(cidade);
    }

    @GetMapping("/historico")
    public List<ConsultaClima> listarHistorico() {
        return climaService.listarHistorico();
    }
}
