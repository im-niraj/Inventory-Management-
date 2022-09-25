package com.nirajkumar.InventoryManagement.Service.ServiceInterface;

import com.nirajkumar.InventoryManagement.model.Item;
import java.util.List;

/**
 *
 * @author nirajkumar
 */
public interface IItemService {
    Item getItemById(long id);

    String validateItemId(long id);

    long findItemIdByLoanId(long loanId);

    List<Item> getAllItems();

    void saveItem(Item item);

    String validateItemId(String itemName, String itemType);

    void deleteItem(long itemId);
}
