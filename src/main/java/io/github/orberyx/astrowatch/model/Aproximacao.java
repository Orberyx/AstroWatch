package io.github.orberyx.astrowatch.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Aproximacao {
    private String asteroideId;
    private LocalDate dataAproximacao;
    private LocalDateTime dataAproximacaoCompleta;
    private double velocidadeKmh;
    private double distanciaKm;
    private double distanciaLunar;
    private String corpoOrbitado;

    public String getAsteroideId() {
        return asteroideId;
    }

    public void setAsteroideId(String asteroideId) {
        this.asteroideId = asteroideId;
    }

    public LocalDate getDataAproximacao(){
        return dataAproximacao;
    }

    public void setDataAproximacao(LocalDate dataAproximacao) {
        this.dataAproximacao = dataAproximacao;
    }

    public LocalDateTime getDataAproximacaoCompleta() {
        return dataAproximacaoCompleta;
    }

    public void setDataAproximacaoCompleta(LocalDateTime dataAproximacaoCompleta) {
        this.dataAproximacaoCompleta = dataAproximacaoCompleta;
    }

    public double getVelocidadeKmh() {
        return velocidadeKmh;
    }

    public void setVelocidadeKmh(double velocidadeKmh) {
        this.velocidadeKmh = velocidadeKmh;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public double getDistanciaLunar() {
        return distanciaLunar;
    }

    public void setDistanciaLunar(double distanciaLunar) {
        this.distanciaLunar = distanciaLunar;
    }

    public String getCorpoOrbitado() {
        return corpoOrbitado;
    }

    public void setCorpoOrbitado(String corpoOrbitado) {
        this.corpoOrbitado = corpoOrbitado;
    }
}
