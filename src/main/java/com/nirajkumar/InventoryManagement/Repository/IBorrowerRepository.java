package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nirajkumar
 */
public interface IBorrowerRepository  extends  JpaRepository<Borrower, Long>{
    
}
