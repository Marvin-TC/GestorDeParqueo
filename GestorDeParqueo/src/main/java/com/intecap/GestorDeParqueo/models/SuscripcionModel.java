package com.intecap.GestorDeParqueo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "suscripcion")
public class SuscripcionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(nullable = false)
   private LocalDateTime fechInicio;
   @Column(nullable = false)
   private LocalDateTime fechaFinalizacion;
   private String tipoSuscripcion;
   double costoSuscpricion;
   private int tiempoMinutosPagado;
   private String estado;

   @ManyToOne
   @JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk-vehiculos-suscripcion"))
    VehiculosModel vehiculoSuscripcion;

    public SuscripcionModel(int id, LocalDateTime fechInicio, LocalDateTime fechaaFinalizacion, String tipoSuscripcion, double costoSuscpricion, int tiempoMinutosPagado, String estado) {
        this.id = id;
        this.fechInicio = fechInicio;
        this.fechaFinalizacion = fechaaFinalizacion;
        this.tipoSuscripcion = tipoSuscripcion;
        this.costoSuscpricion = costoSuscpricion;
        this.tiempoMinutosPagado = tiempoMinutosPagado;
        this.estado = estado;
    }

    public SuscripcionModel() {}

    public Integer getId() {
        return id;
    }

    public LocalDateTime getFechInicio() {
        return fechInicio;
    }

    public LocalDateTime getFechaaFinalizacion() {
        return fechaFinalizacion;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public double getCostoSuscpricion() {
        return costoSuscpricion;
    }

    public int getTiempoMinutosPagado() {
        return tiempoMinutosPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechInicio(LocalDateTime fechInicio) {
        this.fechInicio = fechInicio;
    }

    public void setFechaaFinalizacion(LocalDateTime fechaaFinalizacion) {
        this.fechaFinalizacion = fechaaFinalizacion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public void setCostoSuscpricion(double costoSuscpricion) {
        this.costoSuscpricion = costoSuscpricion;
    }

    public void setTiempoMinutosPagado(int tiempoMinutosPagado) {
        this.tiempoMinutosPagado = tiempoMinutosPagado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
