package com.intecap.GestorDeParqueo.services;

import com.intecap.GestorDeParqueo.models.RegistroPagoModel;
import com.intecap.GestorDeParqueo.models.RegistroParqueoModel;
import com.intecap.GestorDeParqueo.models.VehiculosModel;
import com.intecap.GestorDeParqueo.repositories.RegistroPagoRepository;
import com.intecap.GestorDeParqueo.repositories.RegistroParqueoRepository;
import com.intecap.GestorDeParqueo.repositories.VehiculosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegistroParqueoService {

   private RegistroParqueoRepository parqueoRepository;
   private VehiculosRepository vehiculosRepository;
   private RegistroPagoRepository registroPagoRepository;


    @Autowired
    public RegistroParqueoService(RegistroParqueoRepository parqueoRepository, VehiculosRepository vehiculosRepository, RegistroPagoRepository registroPagoRepository) {
        this.parqueoRepository = parqueoRepository;
        this.vehiculosRepository = vehiculosRepository;
        this.registroPagoRepository = registroPagoRepository;
    }


    public String registrodeEntradaVehiculo (RegistroParqueoModel registroEntrada)
    {
        if (registroEntrada==null){
            return "el registro no puede ser null";
        }
        if (registroEntrada.getVehiculo() !=null && registroEntrada.getVehiculo().getId() !=0)
        {

            if (vehiculosRepository.existsById(registroEntrada.getVehiculo().getId()))
            {
                parqueoRepository.save(registroEntrada);
                return "registro exitoso";
            }else {return "el ID del vehiculo no existe";}
        }
        else
        {return "es neesario el ID del vehiculo";}
    }

    public RegistroParqueoModel registrarSalidaVehiculo(Integer id, LocalDateTime fechaSalida)
    {
            RegistroParqueoModel registroParqueoFinal = parqueoRepository.findById(id).orElseThrow
                    (()-> new EntityNotFoundException("el id del registro no existe: "+id));

        registroParqueoFinal.setMinutosRealesEstacionados(registroParqueoFinal.calcularTiempoRealEstacionado(fechaSalida));
            registroParqueoFinal.setFechaSalida(fechaSalida);
       parqueoRepository.save(registroParqueoFinal);

        RegistroPagoModel pagoParqueo = new RegistroPagoModel();
        int tiemporealCobrado = pagoParqueo.calcularTiempoRealCobro(registroParqueoFinal.getMinutosRealesEstacionados());
        pagoParqueo.setTiempoRealCobrado(tiemporealCobrado);
        pagoParqueo.setTotalCancelado(pagoParqueo.getMontoTotalCancelado(tiemporealCobrado));
        pagoParqueo.setRegistroParqueo(registroParqueoFinal);

        registroPagoRepository.save(pagoParqueo);
        return registroParqueoFinal;
    }
}
