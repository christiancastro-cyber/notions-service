package com.dorcas.notions.domain.port;

import com.dorcas.notions.domain.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository {

    List<Supplier> findAll();

    Optional<Supplier> findById(Long id);

    Supplier save(Supplier supplier);
}