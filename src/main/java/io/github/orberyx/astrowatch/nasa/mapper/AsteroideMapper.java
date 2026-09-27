package io.github.orberyx.astrowatch.nasa.mapper;

import io.github.orberyx.astrowatch.model.Aproximacao;
import io.github.orberyx.astrowatch.model.Asteroide;
import io.github.orberyx.astrowatch.nasa.dto.AproximacaoDto;
import io.github.orberyx.astrowatch.nasa.dto.AsteroideDto;

import java.util.ArrayList;
import java.util.List;

public class AsteroideMapper {
    private final AproximacaoMapper aproximacaoMapper;

    public AsteroideMapper(AproximacaoMapper aproximacaoMapper) {
        this.aproximacaoMapper = aproximacaoMapper;
    }

    public Asteroide toAsteroide(AsteroideDto dto){
        Asteroide asteroide = new Asteroide();

        asteroide.setNome(dto.getName());
        asteroide.setIdNasa(dto.getId());
        asteroide.setDiametroMinKm(dto.getEstimated_diameter().getKilometers().getEstimated_diameter_min());
        asteroide.setDiametroMaxKm(dto.getEstimated_diameter().getKilometers().getEstimated_diameter_max());
        asteroide.setMagnitudeAbsoluta(dto.getAbsolute_magnitude_h());
        asteroide.setPotencialmentePerigoso(dto.isIs_potentially_hazardous_asteroid());
        asteroide.setObjetoSentry(dto.isIs_sentry_object());
        asteroide.setNasaJplUrl(dto.getNasa_jpl_url());

        List<Aproximacao> aproximacoes = new ArrayList<>();
        for (AproximacaoDto dtoAprox : dto.getClose_approach_data()) {
            Aproximacao aprox = aproximacaoMapper.toAproximacao(dtoAprox, dto.getId());
            aproximacoes.add(aprox);
        }
        asteroide.setAproximacoes(aproximacoes);

        return asteroide;
    }
}