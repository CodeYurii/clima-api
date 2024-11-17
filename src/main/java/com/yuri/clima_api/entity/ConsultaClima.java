package com.yuri.clima_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_consulta")
public class ConsultaClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pais", nullable = false)
    private String pais;
    @Column(name = "data", columnDefinition = "DATE", nullable = false)
    private LocalDate data;
    @Column(name = "data_de_consulta", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime dataDeConsulta;
    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;


    public ConsultaClima() {
        this.dataDeConsulta = LocalDateTime.now();
    }

    public ConsultaClima(String pais, LocalDate data, String descricao) {
        this.pais = pais;
        this.data = data;
        this.dataDeConsulta = LocalDateTime.now();
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String toString() {
        return "ConsultaClima{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", data=" + data +
                ", dataDeConsulta=" + dataDeConsulta +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsultaClima that = (ConsultaClima) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
