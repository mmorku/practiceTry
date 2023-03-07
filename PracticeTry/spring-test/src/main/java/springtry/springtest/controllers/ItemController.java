package springtry.springtest.controllers;

import springtry.springtest.converters.ItemConverter;
import springtry.springtest.dto.AddItemDTO;
import springtry.springtest.dto.ItemDTO;
import springtry.springtest.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return ItemConverter.convertItemEntityListToDto(this.itemService.getAllItems());
    }

    @PostMapping
    public void addItem(@RequestBody AddItemDTO itemDTO){
        this.itemService.addItem(ItemConverter.convertAddItemDtoToEntity(itemDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id){
        this.itemService.deleteItemById(id);
    }


    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable Long id) {
        return ItemConverter.convertItemEntityToDto(this.itemService.getItemById(id));
    }

    @GetMapping("/{id}/name")
    public String getItemNameById(@PathVariable Long id) {
        return this.itemService.getNameById(id);
    }

}
