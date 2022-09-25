package com.nirajkumar.InventoryManagement.Service.ServiceInterface;

import com.nirajkumar.InventoryManagement.model.Borrower;
import java.util.List;

/**
 *
 * @author nirajkumar
 */
public interface IBorrowerService {
    Borrower getBorrowerById(long id);

    List<Borrower> getAllBorrowers();

    long getBorrowerIdByLoanId(long loanId);

    String validateBorrowerId(long borrowerId);

    void updateBorrower(Borrower borrower);
}
