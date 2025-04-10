package com.yuri.clima_api.repository;

import com.yuri.clima_api.entity.ConsultaClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaClimaRepository extends JpaRepository<ConsultaClima, Long> {

}
