package org.example.service;

import org.example.entity.Suppliers;
import org.example.repo.SuppliersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuppliersServiceImpl implements SuppliersService{

    @Autowired
    private SuppliersRepo suppliersRepo;

    @Override
    public Suppliers addSupplier(Suppliers suppliers) {
        suppliersRepo.save(suppliers);
        return suppliers;
    }

    @Override
    public List<Suppliers> getAllSuppliers() {
        return suppliersRepo.findAll();
    }

    @Override
    public Suppliers getSupplierById(String supplierId) {
        if(suppliersRepo.findById(supplierId).isPresent()){
            return suppliersRepo.findById(supplierId).get();
        } else {
            return null;
        }
    }

    @Override
    public Suppliers updateSupplierName(String supplierId, String newSupplierName) {

        Optional<Suppliers> supplier = suppliersRepo.findById(supplierId);
        if(supplier.isPresent()){
            Suppliers suppliers = supplier.get();
            suppliers.setSupplierName(newSupplierName);
            System.out.println("Supplier " + supplierId + " is updated");
            return suppliersRepo.save(suppliers);
        }
        else{
            System.out.println("Supplier not found");
            return null;
        }
    }

    @Override
    public void deleteSupplier(String supplierId) {

        if(suppliersRepo.findById(supplierId).isPresent()){
            suppliersRepo.deleteById(supplierId);
            System.out.println("Supplier " + supplierId + " is deleted");
        }
        else{
            System.out.println("Supplier not found");
        }
    }
}
