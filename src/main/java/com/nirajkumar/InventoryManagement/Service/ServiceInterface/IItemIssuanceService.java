package com.nirajkumar.InventoryManagement.Service.ServiceInterface;

import com.nirajkumar.InventoryManagement.model.Loan;
import java.util.List;

/**
 *
 * @author nirajkumar
 */
public interface IItemIssuanceService {
    void saveItemIssued(Loan loan);

    List<Loan> getAllIssuedItems();

    List<Loan> getAllReturnedItem();

    List<Loan> getItemsWithFine();

    void deleteIssuedItemById(long id);

    Loan findItemIssuedById(long id);

    String validateLoanId(long loanId);

    Loan findItemIssued(long borrowerId, long itemId);
}
