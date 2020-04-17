package pl.strefakursow.springadvanced.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.repository.ItemRepository;
import pl.strefakursow.springadvanced.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> getItemsWithQuantityOverTwenty() {
        return itemRepository.getItemsWithQuantityOverTwenty();
    }

    @Override
    public List<Item> getItemsWithQuantityOver(int minQuantityThreshold) {
        return itemRepository.getItemsWithQuantityOver(minQuantityThreshold);
    }

    @Override
    public List<Item> getItemsWithNameLike(String regex) {
        return itemRepository.getItemsWithNameLike(regex);
    }

}