package org.example.controller;

import org.example.entity.Suppliers;
import org.example.service.SuppliersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersServiceImpl suppliersService;

    @PostMapping("/add/{supplierName}")
    public ResponseEntity addSupplier(@PathVariable String supplierName){
        Suppliers suppliers = new Suppliers();
        if(supplierName == null || supplierName.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            suppliers.setSupplierId(UUID.randomUUID().toString());
            suppliers.setSupplierName(supplierName);
            return new ResponseEntity<>(suppliersService.addSupplier(suppliers), HttpStatus.CREATED);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAllSuppliers(){
        return new ResponseEntity<>(suppliersService.getAllSuppliers(), HttpStatus.OK);
    }

    @GetMapping("/get/{supplierId}")
    public ResponseEntity getSupplierById(@PathVariable String supplierId){
        if(supplierId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(suppliersService.getSupplierById(supplierId), HttpStatus.OK);
        }
    }

//    @PostMapping("/update/{supplierId}/{supplierName}")
//    public ResponseEntity updateSupplier(@PathVariable String supplierId,
//                                         @PathVariable String supplierName){
//        if(supplierId == null || supplierName == null || supplierName.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            suppliersService.updateSupplierName(supplierId, supplierName);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }

    @PutMapping("/update/{supplierId}/{supplierName}")
    public ResponseEntity updateSupplierName(@PathVariable String supplierId,
                                         @PathVariable String supplierName){
        if(supplierId == null || supplierName == null || supplierName.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(suppliersService.updateSupplierName(supplierId, supplierName), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{supplierId}")
    public ResponseEntity deleteSupplier(@PathVariable String supplierId){
        if(supplierId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            suppliersService.deleteSupplier(supplierId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
