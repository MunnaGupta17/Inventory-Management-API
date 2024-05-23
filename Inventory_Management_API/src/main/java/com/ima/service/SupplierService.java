package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.models.Supplier;

@Service
public interface SupplierService {
	
	Supplier addSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();

}
