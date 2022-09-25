package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nirajkumar
 */
@Repository
public interface IItemTypeRepository extends JpaRepository<ItemType, Long>{
    
}
