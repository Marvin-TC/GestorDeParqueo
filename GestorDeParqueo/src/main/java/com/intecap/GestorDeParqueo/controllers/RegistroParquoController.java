package com.intecap.GestorDeParqueo.controllers;

import com.intecap.GestorDeParqueo.models.FechaISOModel;
import com.intecap.GestorDeParqueo.models.RegistroParqueoModel;
import com.intecap.GestorDeParqueo.models.VehiculosModel;
import com.intecap.GestorDeParqueo.services.RegistroParqueoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/registroParqueo")
public class RegistroParquoController {

    RegistroParqueoService registroParqueoService;

    @Autowired
    public RegistroParquoController(RegistroParqueoService registroParqueoService) {
        this.registroParqueoService = registroParqueoService;
    }

    @PostMapping("/registrarIngreso")
    public ResponseEntity<String> registrodeIngreso (@RequestBody RegistroParqueoModel DatosRegistroEntrada) {
        try {
            String nuevaEntrada = registroParqueoService.registrodeEntradaVehiculo(DatosRegistroEntrada);
            if (nuevaEntrada.equals("registro exitoso"))
            {
                return ResponseEntity.ok("registro exitoso");
            }else{ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nuevaEntrada);}

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro el vehiculo");
        }
    }

    @PostMapping("/registrarSalida/{id}")
    public ResponseEntity<RegistroParqueoModel> registrodeSalida(@PathVariable Integer id, @RequestBody FechaISOModel fechaISOModel)
    {
        try {
            RegistroParqueoModel registroFinalVehiculo = registroParqueoService.registrarSalidaVehiculo(id,fechaISOModel.getFecha());
            return ResponseEntity.ok(registroFinalVehiculo);
        }catch (EntityNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
