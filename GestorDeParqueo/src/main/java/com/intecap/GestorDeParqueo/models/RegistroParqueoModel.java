package com.intecap.GestorDeParqueo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registroparqueo")
public class RegistroParqueoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDateTime fechaIngreso;
    @Column(nullable = false)
    private LocalDateTime fechaSalida;
    private Integer minutosRealesEstacionados;
    @ManyToOne
    @JoinColumn (name = "id_vehiculos" , nullable = true, foreignKey=@ForeignKey(name = "fk-vehiculos-registroParqueo"))
    private VehiculosModel vehiculo;

     @OneToOne (mappedBy = "registroParqueo",cascade = CascadeType.ALL)
     private RegistroPagoModel registroPago;


    public RegistroParqueoModel(int id, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, Integer minutosRealesEstacionados, VehiculosModel vehiculo) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.minutosRealesEstacionados = minutosRealesEstacionados;
        this.vehiculo = vehiculo;
    }

    public RegistroParqueoModel() {}

    public Integer getId() {
        return id;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public Integer getMinutosRealesEstacionados() {
        return minutosRealesEstacionados;
    }

    public VehiculosModel getVehiculo() {
        return vehiculo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setMinutosRealesEstacionados(Integer minutosRealesEstacionados) {
        this.minutosRealesEstacionados = minutosRealesEstacionados;
    }

    public void setVehiculo(VehiculosModel vehiculo) {
        this.vehiculo = vehiculo;
    }
}
