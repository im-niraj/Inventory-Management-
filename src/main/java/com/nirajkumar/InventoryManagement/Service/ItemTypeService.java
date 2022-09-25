package com.nirajkumar.InventoryManagement.Service;

import com.nirajkumar.InventoryManagement.Repository.IItemTypeRepository;
import com.nirajkumar.InventoryManagement.Service.ServiceInterface.IItemTypeService;
import com.nirajkumar.InventoryManagement.model.ItemType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nirajkumar
 */
@Service
public class ItemTypeService implements IItemTypeService{
    @Autowired
    private IItemTypeRepository itemTypeRepository;

    @Override
    public void saveItemType(ItemType itemType) {
        itemTypeRepository.save(itemType);
    }

    @Override
    public ItemType getItemTypeByName(String name) {
        List<ItemType> itemTypeList = getAllItemTypes();
        ItemType itemType = null;
        for (ItemType it : itemTypeList) {
            if (it.getTypeName().equalsIgnoreCase(name)) {
                itemType = it;
                break;
            }
        }
        return itemType;
    }

    @Override
    public List<ItemType> getAllItemTypes() {
        return itemTypeRepository.findAll();
    }

    @Override
    public String validateItemTypeByName(String name) {
        String errorMessage = "";
        ItemType itemType = getItemTypeByName(name);
        if (itemType == null) {
            errorMessage = "ItemType with name: " + name + " does not exist.";
        }
        return errorMessage;
    }

}
