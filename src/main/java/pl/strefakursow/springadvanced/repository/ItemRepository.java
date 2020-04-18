package pl.strefakursow.springadvanced.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.strefakursow.springadvanced.entity.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("select i from Item i where i.quantity > 20")
    public List<Item> getItemsWithQuantityOverTwenty();

    @Query("select i from Item i where i.quantity>:minQuantityThreshold")
    public List<Item> getItemsWithQuantityOver(@Param("minQuantityThreshold")int minQuantityThreshold);

    @Query("select i from Item i where i.name LIKE :regex")
    public List<Item> getItemsWithNameLike(@Param("regex") String regex);

    public List<Item> findByQuantity(int quantity);

    public List<Item> findByQuantityBetween(Integer minQuantity,Integer maxQuantity);

}
