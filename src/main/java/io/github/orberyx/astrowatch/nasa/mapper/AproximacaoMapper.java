package io.github.orberyx.astrowatch.nasa.mapper;

import io.github.orberyx.astrowatch.model.Aproximacao;
import io.github.orberyx.astrowatch.nasa.dto.AproximacaoDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AproximacaoMapper {
    public Aproximacao toAproximacao(AproximacaoDto dto, String asteroideId){
        Aproximacao aprox = new Aproximacao();

        aprox.setAsteroideId(asteroideId);
        aprox.setDataAproximacao(LocalDate.parse(dto.getClose_approach_date()));
        aprox.setDataAproximacaoCompleta(converteDataAproximacaoCompleta(dto.getClose_approach_date_full()));
        aprox.setVelocidadeKmh(Double.parseDouble(dto.getRelative_velocity().getKilometers_per_hour()));
        aprox.setDistanciaKm(Double.parseDouble(dto.getMiss_distance().getKilometers()));
        aprox.setDistanciaLunar(Double.parseDouble(dto.getMiss_distance().getLunar()));
        aprox.setCorpoOrbitado(dto.getOrbiting_body());
        return aprox;
    }

    private LocalDateTime converteDataAproximacaoCompleta(String dataAproximacaoCompleta){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm", Locale.ENGLISH);
        return LocalDateTime.parse(dataAproximacaoCompleta, formatter);
    }
}
