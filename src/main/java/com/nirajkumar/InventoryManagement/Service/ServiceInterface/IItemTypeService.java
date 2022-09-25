package com.nirajkumar.InventoryManagement.Service.ServiceInterface;

import com.nirajkumar.InventoryManagement.model.ItemType;
import java.util.List;

/**
 *
 * @author nirajkumar
 */
public interface IItemTypeService {
    void saveItemType(ItemType itemType);
    ItemType getItemTypeByName(String name);
    List<ItemType> getAllItemTypes();
    String validateItemTypeByName(String name);
}
