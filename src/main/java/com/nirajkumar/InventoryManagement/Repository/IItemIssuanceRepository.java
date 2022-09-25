package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nirajkumar
 */
@Repository
public interface IItemIssuanceRepository extends JpaRepository<Loan, Long>{
    
}
