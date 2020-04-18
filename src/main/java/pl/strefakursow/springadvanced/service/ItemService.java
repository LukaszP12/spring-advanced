package pl.strefakursow.springadvanced.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.springadvanced.entity.Item;

import java.util.List;

public interface ItemService {

    public void saveItem(Item item);

    public List<Item> getItemsWithQuantityOverTwenty();

    public List<Item> getItemsWithQuantityOver(int minQuantityThreshold);

    public List<Item> getItemsWithNameLike(String regex);

    public List<Item> findByQuantity(int quantity);

    public List<Item> findByQuantityBetween(int min, int max);

}
