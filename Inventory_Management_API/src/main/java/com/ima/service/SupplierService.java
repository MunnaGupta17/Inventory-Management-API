package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.exception.ResourceNotFoundException;
import com.ima.exception.SupplierException;
import com.ima.models.Supplier;

@Service
public interface SupplierService {
	
	Supplier addSupplier(Supplier supplier)throws ResourceNotFoundException;
    List<Supplier> getAllSuppliers();
    Supplier getSupplier(Long supplierId)throws SupplierException;
    Supplier updateSupplier(Long supplierId, Supplier updatedSupplier)throws ResourceNotFoundException,SupplierException;
    String removeSupplier(Long supplierId)throws SupplierException;

}
