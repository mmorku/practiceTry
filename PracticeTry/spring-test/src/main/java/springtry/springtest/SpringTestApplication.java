package springtry.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import springtry.springtest.services.ItemService;

@SpringBootApplication
public class SpringTestApplication {

    @Autowired
    private ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        this.itemService.loadTestData();
        tests();
    }

    public void tests() {
        System.out.println("--------------------------------------");
        System.out.println("TEST: printAllItems");
        this.itemService.printAllItems();
        System.out.println("--------------------------------------");
        System.out.println("TEST: deleteItemByName");
        this.itemService.deleteItemByName("Phone");
        System.out.println("--------------------------------------");
        System.out.println("TEST: printAllItems pageable");
        int pageSize = 4;
        System.out.println("First page");
        this.itemService.printAllItemsPageable(PageRequest.of(0, pageSize));
        System.out.println("Second page");
        this.itemService.printAllItemsPageable(PageRequest.of(1, pageSize));
        System.out.println("Third page");
        this.itemService.printAllItemsPageable(PageRequest.of(2, pageSize));
        System.out.println("Fourth page");
        this.itemService.printAllItemsPageable(PageRequest.of(3, pageSize));
        System.out.println("Fifth page");
        this.itemService.printAllItemsPageable(PageRequest.of(4, pageSize));
        System.out.println("Sixth page");
        this.itemService.printAllItemsPageable(PageRequest.of(5, pageSize));
        System.out.println("--------------------------------------");
        this.itemService.updateItemNameById(3L, "Monitor");
        this.itemService.deleteItemByName("Table");
        System.out.println("--------------------------------------");
        System.out.println("TEST: printItemByName");
        this.itemService.printItemsByName("Phone");
        System.out.println("--------------------------------------");
    }
}
