package com.yuri.clima_api.service;

import com.yuri.clima_api.dto.ClimaDTO;
import com.yuri.clima_api.entity.ConsultaClima;
import com.yuri.clima_api.repository.ConsultaClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class ClimaService {

    @Autowired
    private ConsultaClimaRepository repository;

    public ClimaDTO buscarClima(String cidade) {
        String apiKey = "SUA_API_KEY";
        String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=pt_br",
                cidade, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(url, Map.class);

        if (response != null) {
            ClimaDTO clima = new ClimaDTO();
            clima.setCidade((String) response.get("name"));
            var main = (Map<String, Object>) response.get("main");
            clima.setTemperatura((Double) main.get("temp"));
            var weather = (Map<String, Object>) ((List<?>) response.get("weather")).get(0);
            clima.setDescricao((String) weather.get("description"));

            // Salvar no banco
            ConsultaClima consulta = new ConsultaClima();
            consulta.setCidade(clima.getCidade());
            consulta.setTemperatura(clima.getTemperatura());
            consulta.setDescricao(clima.getDescricao());
            consulta.setDataConsulta(LocalDateTime.now());
            repository.save(consulta);

            return clima;
        }
        return null;
    }

    public List<ConsultaClima> listarHistorico() {
        return repository.findAll(); // Recupera todas as consultas do banco
    }

}

