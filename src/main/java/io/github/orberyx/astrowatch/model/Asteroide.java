package io.github.orberyx.astrowatch.model;

import java.util.List;

public class Asteroide {
    private String idNasa;
    private String nome;
    private double diametroMinKm;
    private double diametroMaxKm;
    private double magnitudeAbsoluta;
    private boolean potencialmentePerigoso;
    private boolean objetoSentry;
    private String nasaJplUrl;
    private List<Aproximacao> aproximacoes;

    public String getIdNasa() {
        return idNasa;
    }

    public void setIdNasa(String idNasa) {
        this.idNasa = idNasa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDiametroMinKm() {
        return diametroMinKm;
    }

    public void setDiametroMinKm(double diametroMinKm) {
        this.diametroMinKm = diametroMinKm;
    }

    public double getDiametroMaxKm() {
        return diametroMaxKm;
    }

    public void setDiametroMaxKm(double diametroMaxKm) {
        this.diametroMaxKm = diametroMaxKm;
    }

    public double getMagnitudeAbsoluta() {
        return magnitudeAbsoluta;
    }

    public void setMagnitudeAbsoluta(double magnitudeAbsoluta) {
        this.magnitudeAbsoluta = magnitudeAbsoluta;
    }

    public boolean isPotencialmentePerigoso() {
        return potencialmentePerigoso;
    }

    public void setPotencialmentePerigoso(boolean potencialmentePerigoso) {
        this.potencialmentePerigoso = potencialmentePerigoso;
    }

    public boolean isObjetoSentry() {
        return objetoSentry;
    }

    public void setObjetoSentry(boolean objetoSentry) {
        this.objetoSentry = objetoSentry;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public List<Aproximacao> getAproximacoes() {
        return aproximacoes;
    }

    public void setAproximacoes(List<Aproximacao> aproximacoes) {
        this.aproximacoes = aproximacoes;
    }
}
