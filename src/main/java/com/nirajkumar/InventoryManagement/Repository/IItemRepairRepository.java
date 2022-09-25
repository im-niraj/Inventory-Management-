package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.ItemRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nirajkumar
 */
@Repository
public interface IItemRepairRepository extends JpaRepository<ItemRepair, Long>{
    
}
