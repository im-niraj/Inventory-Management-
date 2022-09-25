package com.nirajkumar.InventoryManagement.Service.ServiceInterface;

import com.nirajkumar.InventoryManagement.model.Vendor;

/**
 *
 * @author nirajkumar
 */
public interface IVendorService {
    Vendor getVendorById(long id);

    Vendor getVendorByName(String name);

    String validateVendorId(long id);

    String validateVendorName(String vendorName);
}
