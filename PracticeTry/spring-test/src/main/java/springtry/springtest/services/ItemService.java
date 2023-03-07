package springtry.springtest.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springtry.springtest.entities.Item;
import springtry.springtest.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item) {
        this.itemRepository.saveAndFlush(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);

        if (!item.isPresent()) {
            return null;
        }

        return item.get();
    }

    public String getNameById(Long id) {
        Optional<Item> item = itemRepository.findById(id);

        if (!item.isPresent()) {
            return null;
        }

        return item.get().getManufacturer();
    }

    private Page<Item> getAllItemsPageable(Pageable pageable) {
        Page<Item> itemPage = itemRepository.findAll(pageable);
        return itemPage;
    }

    private void addTestItems() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setName("Name-" + i);
            item.setManufacturer("Manufacturer-" + i);
            item.setManufacturedDate("ManufacturedDate" + i);
            item.setModel("Model-" + i);
            item.setWeight(1 + i);
            item.setPrice(1 + i);
            item.setAvailability(1 + i);
            this.itemRepository.saveAndFlush(item);
        }
    }

    public void loadTestData() {
        addTestItems();
    }

    public void printItemsByName(String name) {
        this.itemRepository.saveAndFlush(new Item(1L, "Phone", "Nokia", "3310", "2000-09-01", 1, 1000, 2));
        this.itemRepository.saveAndFlush(new Item(2L, "Table", "IKEA", "BA201", ".01", 35,110, 10));
        this.itemRepository.saveAndFlush(new Item(3L, "Watch", "Apple", "SE", "2020.05.01",1, 450, 10));
        this.itemRepository.saveAndFlush(new Item(4L, "Phone", "Apple", "12 Pro", "2021.02.01",1, 1200, 8));

        System.out.println("Item found by name: " + this.itemRepository.countByName(name));
        System.out.println(this.itemRepository.findFirstByName(name));
    }

    public void printAllItems() {
        for (Item s : getAllItems()) {
            System.out.println(s);
        }
    }

    public void printAllItemsPageable(Pageable pageable) {
        for (Item i : getAllItemsPageable(pageable)) {
            System.out.println(i);
        }
    }

    public void deleteItemByName(String name) {
        this.itemRepository.deleteAllByName(name);
    }

    public void deleteItemById(Long id) {
        this.itemRepository.deleteById(id);
    }

    public void updateItemNameById(Long id, String name) {
        Item item = this.itemRepository.findById(id).get();
        item.setManufacturer(name);
        this.itemRepository.saveAndFlush(item);
    }

}
