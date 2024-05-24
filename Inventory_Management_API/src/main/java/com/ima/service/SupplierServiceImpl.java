package com.ima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ima.models.Supplier;
import com.ima.repository.SupplierRepository;

public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
    private SupplierRepository supplierRepository;


	@Override
	public Supplier addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

}
