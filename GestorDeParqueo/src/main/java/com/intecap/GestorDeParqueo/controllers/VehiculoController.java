package com.intecap.GestorDeParqueo.controllers;

import com.intecap.GestorDeParqueo.models.VehiculosModel;
import com.intecap.GestorDeParqueo.services.VehiculoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("api/vehiculos")
public class VehiculoController {

    VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/buscarVehiculo/{id}")
    public ResponseEntity<VehiculosModel> buscarVehiculo(@PathVariable Integer id)
    {
       try {
           VehiculosModel vehiculoBuscado = vehiculoService.buscarVehiculo(id);
           return ResponseEntity.ok(vehiculoBuscado);
       }catch (EntityNotFoundException e)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }
    }
    @DeleteMapping("/eliminarVehiculo/{id}")
    public ResponseEntity<String> eliminarVehiculo (@PathVariable Integer id)
    {
        String resultado = vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.badRequest().body(resultado);
    }

    @PostMapping("/actualizarVehiculo/{id}")
    public ResponseEntity<String> actualizarVehiculo(@PathVariable Integer id, @RequestBody VehiculosModel nuevaInformacionVehiculo)
    {
        try {
            VehiculosModel vehiculoActualizado = vehiculoService.actualizarVehiculos(id,nuevaInformacionVehiculo);
            return ResponseEntity.ok("Actualziacion exitosa ");
        }catch (EntityNotFoundException e)
        {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

}
