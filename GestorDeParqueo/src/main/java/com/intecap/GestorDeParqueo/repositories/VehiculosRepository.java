package com.intecap.GestorDeParqueo.repositories;

import com.intecap.GestorDeParqueo.models.VehiculosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculosRepository extends JpaRepository<VehiculosModel,Integer> {

    List<VehiculosModel> findByTipoVehiculo (String tipo);
}
