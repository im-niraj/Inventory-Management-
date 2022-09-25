package com.nirajkumar.InventoryManagement.Service;

import com.nirajkumar.InventoryManagement.Repository.IVendorRepository;
import com.nirajkumar.InventoryManagement.Service.ServiceInterface.IVendorService;
import com.nirajkumar.InventoryManagement.model.Vendor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nirajkumar
 */
@Service
public class VendorService implements IVendorService{
    @Autowired
    private IVendorRepository vendorRepository;

    @Override
    public Vendor getVendorById(long id) {
        Optional<Vendor> optional = vendorRepository.findById(id);
        Vendor vendor = null;
        if (optional.isPresent()) {
            vendor = optional.get();
        } else {
            // Exception
        }
        return vendor;
    }

    @Override
    public Vendor getVendorByName(String name) {
        List<Vendor> vendorList = vendorRepository.findAll();
        Vendor vendor = null;
        for (Vendor v : vendorList) {
            if (v.getName().equalsIgnoreCase(name)) {
                vendor = v;
                break;
            }
        }
        return vendor;
    }

    @Override
    public String validateVendorId(long id) {
        String errorMessage = "";
        Vendor vendor = getVendorById(id);
        if (vendor == null) {
            errorMessage = "Vendor ID does not exist";
        }

        return errorMessage;
    }

    @Override
    public String validateVendorName(String vendorName) {
        String errorMessage = "";
        Vendor vendor = getVendorByName(vendorName);
        if (vendor == null) {
            errorMessage = "Vendor with name: " + vendorName + " does not exist.";
        }
        return errorMessage;
    }

}
