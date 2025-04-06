package com.intecap.GestorDeParqueo.models;

import java.time.LocalDateTime;

public class FechaISOModel {
    private LocalDateTime fecha;

    public FechaISOModel(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public FechaISOModel() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
