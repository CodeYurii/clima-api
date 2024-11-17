package com.yuri.clima_api.service;

import com.yuri.clima_api.dto.ClimaDTO;
import com.yuri.clima_api.entity.ConsultaClima;
import com.yuri.clima_api.repository.ConsultaClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


@Service
public class ClimaService {

    private final RestTemplate restTemplate;
    private final ConsultaClimaRepository consultaClimaRepository;



    public ClimaService(RestTemplate restTemplate, ConsultaClimaRepository consultaClimaRepository) {
        this.restTemplate = restTemplate;
        this.consultaClimaRepository = consultaClimaRepository;
    }

    public ClimaDTO buscarClima(String pais, String token) {
        String url = "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/" + pais + "?token=" + token;

        try {
            ResponseEntity<ClimaDTO> response = restTemplate.getForEntity(url, ClimaDTO.class);
            ClimaDTO climaResponse = response.getBody(); // Pegando o primeiro elemento

            ConsultaClima consultaClima = new ConsultaClima();
            consultaClima.setPais(climaResponse.getPais());
            consultaClima.setData(climaResponse.getData());
            consultaClima.setDescricao(climaResponse.getDescricao());
            consultaClima.setDataDeConsulta(climaResponse.getDataDeConsulta());
            consultaClimaRepository.save(consultaClima);

            return new ClimaDTO(consultaClima);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar a API de clima: " + e.getMessage(), e);
        }
    }
}
