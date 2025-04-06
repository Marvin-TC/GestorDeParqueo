package com.intecap.GestorDeParqueo.repositories;


import com.intecap.GestorDeParqueo.models.RegistroParqueoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroParqueoRepository  extends JpaRepository<RegistroParqueoModel,Integer> {
}
