package com.intecap.GestorDeParqueo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "registropago")
public class RegistroPagoModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private int tiempoRealCobrado;
    double totalCancelado;

   @OneToOne
    @JoinColumn(name = "id_registroParqueo", unique = true, foreignKey = @ForeignKey(name = "fk-registroParqueo-registroPago"))
    private RegistroParqueoModel registroParqueo;

    public RegistroPagoModel(Integer id, int tiempoRealCobrado, double totalCancelado) {
        this.id = id;
        this.tiempoRealCobrado = tiempoRealCobrado;
        this.totalCancelado = totalCancelado;
    }

    public RegistroPagoModel() {
    }

    public Integer getId() {
        return id;
    }

    public int getTiempoRealCobrado() {
        return tiempoRealCobrado;
    }

    public double getTotalCancelado() {
        return totalCancelado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTiempoRealCobrado(int tiempoRealCobrado) {
        this.tiempoRealCobrado = tiempoRealCobrado;
    }

    public void setTotalCancelado(double totalCancelado) {
        this.totalCancelado = totalCancelado;
    }
}
