package com.nirajkumar.InventoryManagement.Service.ServiceInterface;

import com.nirajkumar.InventoryManagement.model.ItemRepair;
import java.util.List;

/**
 *
 * @author nirajkumar
 */
public interface IItemRepairService {
    
    List<ItemRepair> getAllRepairItems();

    void saveItemRepair(ItemRepair itemRepair);

    void deleteItemRepairById(long id);

    ItemRepair findItemRepairById(long id);
}
