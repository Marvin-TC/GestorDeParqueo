package com.intecap.GestorDeParqueo.repositories;

import com.intecap.GestorDeParqueo.models.RegistroPagoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPagoRepository extends JpaRepository<RegistroPagoModel,Integer> {
}
