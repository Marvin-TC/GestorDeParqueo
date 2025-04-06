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


    @Transient
    private final double  PRECIO_POR_MINUTO_HORA_FRACCION =0.0833;

    @OneToOne
    @JoinColumn(name = "id_registro_parqueo", unique = true, foreignKey = @ForeignKey(name = "fk-registroParqueo-registroPago"))
    private RegistroParqueoModel registroParqueo;

    public RegistroPagoModel(Integer id, int tiempoRealCobrado, double totalCancelado) {
        this.id = id;
        this.tiempoRealCobrado = tiempoRealCobrado;
        this.totalCancelado = totalCancelado;
    }

    public RegistroPagoModel() {
    }

    public RegistroParqueoModel getRegistroParqueo() {
        return registroParqueo;
    }

    public void setRegistroParqueo(RegistroParqueoModel registroParqueo) {
        this.registroParqueo = registroParqueo;
    }

    public double getTotalCancelado() {
        return totalCancelado;
    }

    public int getTiempoRealCobrado() {
        return tiempoRealCobrado;
    }

    public Integer getId() {
        return id;
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


    public int calcularTiempoRealCobro(int minutosreales)
    {
        final int MEDIA_HORA = 30;
        final int HORA = 60;
        final int MARGEN = 10; // margen de 10 minutos

        if (minutosreales <= MEDIA_HORA) {return MEDIA_HORA;}
        if (minutosreales > MEDIA_HORA && minutosreales <= MEDIA_HORA + MARGEN) {return MEDIA_HORA;}
        if (minutosreales > MEDIA_HORA + MARGEN && minutosreales < HORA) {return HORA;}

        // Para tiempos de 1 hora o más:
        int horasCompletas = minutosreales / HORA;
        int resto = minutosreales % HORA;
        int tiempoCobrado = horasCompletas * HORA; // carga por las horas completas

        if (resto <= MARGEN) {return tiempoCobrado;}
        else if (resto <= MEDIA_HORA + MARGEN) {
            return tiempoCobrado + MEDIA_HORA;
        }
        else {return tiempoCobrado + HORA;}
    }

    public double getMontoTotalCancelado(int tiemporeal) {
        return (double) tiemporeal*PRECIO_POR_MINUTO_HORA_FRACCION;
    }
}
