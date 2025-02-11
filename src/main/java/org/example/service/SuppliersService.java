package org.example.service;

import org.example.entity.Suppliers;

import java.util.List;

public interface SuppliersService {

    Suppliers addSupplier(Suppliers suppliers);
    List<Suppliers> getAllSuppliers();
    Suppliers getSupplierById(String supplierId);
    Suppliers updateSupplierName(String supplierId, String newSupplierName);
    void deleteSupplier(String supplierId);

}
