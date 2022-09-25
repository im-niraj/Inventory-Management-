package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nirajkumar
 */
@Repository
public interface IItemRepository extends JpaRepository<Item, Long>{
    
}
