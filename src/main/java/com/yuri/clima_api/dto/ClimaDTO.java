package com.yuri.clima_api.dto;

import com.yuri.clima_api.entity.ConsultaClima;
import org.springframework.beans.BeanUtils;

public class ClimaDTO {


    private String cidade;
    private Double temperatura;
    private String descricao;

    public ClimaDTO(){}

    public ClimaDTO(ConsultaClima entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
}
