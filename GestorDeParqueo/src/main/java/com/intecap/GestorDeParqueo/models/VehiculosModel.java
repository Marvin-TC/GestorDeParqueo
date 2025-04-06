package com.intecap.GestorDeParqueo.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehiculos")
public class VehiculosModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombrePropietario;
    private String numeroPropietario;
    @Column (unique = true, nullable = false)
    private String placa;
    private String marca;
    private String tipoVehiculo;

    @OneToMany (mappedBy = "vehiculo" , cascade = CascadeType.PERSIST)
    List<RegistroParqueoModel> listRegistroparqueo;

    @OneToMany(mappedBy = "vehiculoSuscripcion", cascade = CascadeType.ALL)
    List<SuscripcionModel> listSuscripcion;

    public VehiculosModel(int id, String nombrePropietario, String numeroPropietario, String placa, String marca, String tipoVehiculo) {
        this.id = id;
        this.nombrePropietario = nombrePropietario;
        this.numeroPropietario = numeroPropietario;
        this.placa = placa;
        this.marca = marca;
        this.tipoVehiculo = tipoVehiculo;
    }

    public VehiculosModel() {}

    public Integer getId() {
        return id;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getNumeroPropietario() {
        return numeroPropietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public void setNumeroPropietario(String numeroPropietario) {
        this.numeroPropietario = numeroPropietario;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
