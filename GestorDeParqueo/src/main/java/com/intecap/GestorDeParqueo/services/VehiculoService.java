package com.intecap.GestorDeParqueo.services;

import com.intecap.GestorDeParqueo.models.VehiculosModel;
import com.intecap.GestorDeParqueo.repositories.VehiculosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    VehiculosRepository vehiculosRepository;

    @Autowired
    public VehiculoService(VehiculosRepository vehiculosRepository) {
        this.vehiculosRepository = vehiculosRepository;
    }

    public VehiculosModel insertarVehiculo (VehiculosModel vehiculoNuevo)
    {
        return  vehiculosRepository.save(vehiculoNuevo);
    }
    public String eliminarVehiculo (Integer id)
    {
        if (vehiculosRepository.existsById(id))
        {
            vehiculosRepository.deleteById(id);
            return "vehiculo eliminado correctamente";
        }else{
            return "no existe ningun vehiculo con id proporcionado";
        }
    }
    public VehiculosModel buscarVehiculo (Integer id)
    {
        return vehiculosRepository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con ID: " + id));
    }

    public VehiculosModel actualizarVehiculos(Integer id, VehiculosModel datosnuevos)
    {
       vehiculosRepository.findById(id).orElseThrow(()  -> new EntityNotFoundException("Vehículo no encontrado con ID: " + id));
        datosnuevos.setId(id);
        return vehiculosRepository.save(datosnuevos);


    }




}
