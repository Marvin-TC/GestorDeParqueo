package com.intecap.GestorDeParqueo.repositories;

import com.intecap.GestorDeParqueo.models.SuscripcionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuscripcionRepository extends JpaRepository<SuscripcionModel,Integer> {

    List<SuscripcionModel> findByEstado (String estado);
}
