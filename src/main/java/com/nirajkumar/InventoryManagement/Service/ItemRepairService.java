package com.nirajkumar.InventoryManagement.Service;

import com.nirajkumar.InventoryManagement.Repository.IItemRepairRepository;
import com.nirajkumar.InventoryManagement.Service.ServiceInterface.IItemRepairService;
import com.nirajkumar.InventoryManagement.model.ItemRepair;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author nirajkumar
 */
@Service
public class ItemRepairService implements IItemRepairService{
    @Autowired
    private IItemRepairRepository itemRepairRepository;

    @Override
    public List<ItemRepair> getAllRepairItems() {
        return itemRepairRepository.findAll();
    }

    @Override
    public void saveItemRepair(ItemRepair itemRepair) {
        this.itemRepairRepository.save(itemRepair);
    }

    @Override
    public void deleteItemRepairById(long id) {
        this.itemRepairRepository.deleteById(id);
    }

    @Override
    public ItemRepair findItemRepairById(long id) {
        Optional<ItemRepair> optional = itemRepairRepository.findById(id);
        ItemRepair itemRepair = null;
        if (optional.isPresent()) {
                itemRepair = optional.get();
        } else {
                // Exception
        }
        return itemRepair;
    }
  
}
