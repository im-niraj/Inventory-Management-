package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nirajkumar
 */
@Repository
public interface IVendorRepository extends JpaRepository<Vendor, Long>{
    
}
