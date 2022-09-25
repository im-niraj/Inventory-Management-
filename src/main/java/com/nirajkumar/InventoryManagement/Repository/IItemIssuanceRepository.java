package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nirajkumar
 */
public interface IItemIssuanceRepository extends JpaRepository<Loan, Long>{
    
}
