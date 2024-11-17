package com.yuri.clima_api.dto;


import com.yuri.clima_api.entity.ConsultaClima;
import org.springframework.beans.BeanUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClimaDTO {

    private String pais;
    private LocalDate data;
    private LocalDateTime dataDeConsulta;
    private String descricao;

    public ClimaDTO(){}

    public ClimaDTO(String pais, LocalDate data, String descricao, LocalDateTime dataDeConsulta) {
        this.pais = pais;
        this.data = data;
        this.descricao = descricao;
        this.dataDeConsulta = dataDeConsulta != null ? dataDeConsulta : LocalDateTime.now();
    }

    public ClimaDTO(ConsultaClima entity) {
        BeanUtils.copyProperties(entity, this);
        this.dataDeConsulta = entity.getDataDeConsulta();
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDateTime getDataDeConsulta() {
        return dataDeConsulta;
    }

    public void setDataDeConsulta(LocalDateTime dataDeConsulta) {
        this.dataDeConsulta = dataDeConsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClimaDTO climaDTO = (ClimaDTO) o;
        return pais.equals(climaDTO.pais) && data.equals(climaDTO.data);
    }

    @Override
    public int hashCode() {
        int result = pais.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }
}
