package com.ima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ima.exception.ResourceNotFoundException;
import com.ima.exception.SupplierException;
import com.ima.models.Supplier;
import com.ima.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	
	@Autowired
    private SupplierService supplierService;
	
	@PostMapping("/add")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) throws ResourceNotFoundException {
        Supplier newSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.ok(newSupplier);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAllSuppliers() throws SupplierException {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") Long supplierId) throws SupplierException, ResourceNotFoundException {
        Supplier supplier = supplierService.getSupplier(supplierId);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") Long supplierId, @RequestBody Supplier updatedSupplier) throws ResourceNotFoundException, SupplierException {
        Supplier supplier = supplierService.updateSupplier(supplierId, updatedSupplier);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeSupplier(@PathVariable("id") Long supplierId) throws SupplierException, ResourceNotFoundException {
        String response = supplierService.removeSupplier(supplierId);
        return ResponseEntity.ok(response);
    }


}
