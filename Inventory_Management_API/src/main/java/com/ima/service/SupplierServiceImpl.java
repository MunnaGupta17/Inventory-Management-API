package com.ima.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ima.exception.ResourceNotFoundException;
import com.ima.exception.SupplierException;
import com.ima.models.Supplier;
import com.ima.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
    private SupplierRepository supplierRepository;

	@Override
	public Supplier addSupplier(Supplier supplier) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (supplier == null) {
            throw new ResourceNotFoundException("Supplier object is null.");
        }
		return supplierRepository.save(supplier);
		
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

	@Override
	public Supplier getSupplier(Long supplierId) throws SupplierException {
		// TODO Auto-generated method stub
		Optional<Supplier> supplier = supplierRepository.findById(supplierId);
        if (supplier.isPresent()) {
            return supplier.get();
        } else {
            throw new SupplierException("Supplier not found with id: " + supplierId);
        }
	}

	@Override
	public Supplier updateSupplier(Long supplierId, Supplier updatedSupplier)
			throws ResourceNotFoundException, SupplierException {
		// TODO Auto-generated method stub
		if (updatedSupplier == null) {
            throw new ResourceNotFoundException("Updated supplier object is null.");
        }
		Optional<Supplier> existingSupplierOpt = supplierRepository.findById(supplierId);
        if (existingSupplierOpt.isPresent()) {
            Supplier existingSupplier = existingSupplierOpt.get();
            BeanUtils.copyProperties(updatedSupplier, existingSupplier, "id");
            return supplierRepository.save(existingSupplier);
        } else {
            throw new SupplierException("Supplier not found with id: " + supplierId);
        }
	}

	@Override
	public String removeSupplier(Long supplierId) throws SupplierException {
		// TODO Auto-generated method stub
		Optional<Supplier> supplier = supplierRepository.findById(supplierId);
        if (supplier.isPresent()) {
            supplierRepository.delete(supplier.get());
            return "Supplier removed successfully.";
        } else {
            throw new SupplierException("Supplier not found with id: " + supplierId);
        }
	}



}
