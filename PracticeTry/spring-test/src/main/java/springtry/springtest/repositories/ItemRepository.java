package springtry.springtest.repositories;

import jakarta.transaction.Transactional;
import springtry.springtest.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {

    // -------------------------------------------------------------------------------------------
    // Suranda pirma pagal varda
    Item findFirstByName(String name);

    // -------------------------------------------------------------------------------------------
    // Apskaiciuoja kieki su nurodytu vardu
    int countByName(String name);
    // -------------------------------------------------------------------------------------------
    // Istrina visus pagal varda
    @Transactional
    void deleteAllByName(String name);
    // -------------------------------------------------------------------------------------------

}
