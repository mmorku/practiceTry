package springtry.springtest.converters;

import springtry.springtest.dto.AddItemDTO;
import springtry.springtest.dto.ItemDTO;
import springtry.springtest.entities.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemConverter {

    public static Item convertAddItemDtoToEntity(AddItemDTO itemDTO) {
        Item item = null;
        if (itemDTO != null) {
            item = new Item();
            item.setName(itemDTO.getName());
            item.setManufacturer(itemDTO.getManufacturer());
            item.setModel(itemDTO.getModel());
            item.setManufacturedDate(itemDTO.getManufacturedDate());
            item.setWeight(itemDTO.getWeight());
            item.setPrice(itemDTO.getPrice());
            item.setAvailability(itemDTO.getAvailability());
        }
        return item;
    }
    public static ItemDTO convertItemEntityToDto(Item item){
        ItemDTO itemDTO = null;
        if (item != null){
            itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setName(item.getName());
            itemDTO.setManufacturer(item.getManufacturer());
            itemDTO.setModel(item.getModel());
            itemDTO.setManufacturedDate(item.getManufacturedDate());
            itemDTO.setWeight(item.getWeight());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setAvailability(item.getAvailability());
        }
        return itemDTO;
    }

    public static List<ItemDTO> convertItemEntityListToDto(List<Item> itemList){
        List<ItemDTO> itemDTOList = null;
        for (Item s: itemList) {
            if (itemDTOList == null){
                itemDTOList = new ArrayList<>();
            }
            itemDTOList.add(ItemConverter.convertItemEntityToDto(s));
        }
        return itemDTOList;
    }

}
