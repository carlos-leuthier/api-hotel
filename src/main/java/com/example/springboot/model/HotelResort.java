package com.example.springboot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "hotel_id")
public class HotelResort extends Hotel {
    private int salaReuniao;
    private int quantidadeBanheiras;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public HotelResort() {
        super();
    }

    public HotelResort(int salaReuniao, int quantidadeBanheiras, Endereco endereco) {
        super();
        this.salaReuniao = salaReuniao;
        this.quantidadeBanheiras = quantidadeBanheiras;
        this.endereco = endereco;
    }

    public int getSalaReuniao() {
        return salaReuniao;
    }

    public void setSalaReuniao(int salaReuniao) {
        this.salaReuniao = salaReuniao;
    }

    public int getQuantidadeBanheiras() {
        return quantidadeBanheiras;
    }

    public void setQuantidadeBanheiras(int quantidadeBanheiras) {
        this.quantidadeBanheiras = quantidadeBanheiras;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

