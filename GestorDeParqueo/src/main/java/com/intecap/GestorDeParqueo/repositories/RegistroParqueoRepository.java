package com.intecap.GestorDeParqueo.repositories;


import com.intecap.GestorDeParqueo.models.RegistroParqueoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroParqueoRepository  extends JpaRepository<RegistroParqueoModel,Integer> {

}
