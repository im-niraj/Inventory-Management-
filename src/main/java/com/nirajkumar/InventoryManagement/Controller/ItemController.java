package com.nirajkumar.InventoryManagement.Controller;

import com.nirajkumar.InventoryManagement.Convertor.ItemConvertor;
import com.nirajkumar.InventoryManagement.DTO.ItemDto;
import com.nirajkumar.InventoryManagement.Service.ItemService;
import com.nirajkumar.InventoryManagement.Service.ItemTypeService;
import com.nirajkumar.InventoryManagement.Service.VendorService;
import com.nirajkumar.InventoryManagement.model.Item;
import com.nirajkumar.InventoryManagement.model.ItemType;
import com.nirajkumar.InventoryManagement.model.Vendor;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nirajkumar
 */
@Controller
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemTypeService itemTypeService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ItemConvertor itemConvertor;

    @GetMapping("/ItemView")
    public String View(Model model) {
        model.addAttribute("itemDtoList", itemConvertor.modelToDto(itemService.getAllItems()));
        return "/Item/View";
    }

    @GetMapping("/ItemCreate")
    public String Create(Model model) {
        ItemDto itemDto = new ItemDto();
        model.addAttribute("itemDto", itemDto);
        model.addAttribute("itemTypeList", itemTypeService.getAllItemTypes());
        return "/Item/Create";
    }

    @PostMapping("/ItemCreate")
    public String Create(@Valid @ModelAttribute("itemDto") ItemDto itemDto, BindingResult result, Model model) {
        Vendor vendor = null;
        ItemType itemType = null;
        Item item = null;
        String err = vendorService.validateVendorName(itemDto.getVendorName());
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        } else {
            vendor = vendorService.getVendorByName(itemDto.getVendorName());
        }
        err = itemTypeService.validateItemTypeByName(itemDto.getItemType());
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        } else {
            itemType = itemTypeService.getItemTypeByName(itemDto.getItemType());
        }
        err = itemService.validateItemId(itemDto.getItemName(), itemDto.getItemType());
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }

        if (result.hasErrors()) {
            model.addAttribute("itemDtoList", itemConvertor.modelToDto(itemService.getAllItems()));
            return "/Item/Create";
        }
        item = itemConvertor.dtoToModel(itemDto);
        item.setVendor(vendor);
        item.setItemType(itemType);
        itemService.saveItem(item);
        return "redirect:/ItemView";
    }

    @GetMapping("/ItemEdit/{id}")
    public String Edit(@PathVariable(value = "id") long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("itemDto", itemConvertor.modelToDto(item));
        model.addAttribute("itemTypeList", itemTypeService.getAllItemTypes());
        return "/Item/Edit";
    }

    @GetMapping("/ItemDelete/{id}")
    public String Delete(@PathVariable(value = "id") long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("itemDto", itemConvertor.modelToDto(item));
        return "/Item/Delete";
    }

    @PostMapping("/ItemDelete/{id}")
    public String Delete(@PathVariable(value = "id") long id, @ModelAttribute("itemDto") ItemDto itemDto) {
        itemService.deleteItem(id);
        return "redirect:/ItemView";
    }

}
