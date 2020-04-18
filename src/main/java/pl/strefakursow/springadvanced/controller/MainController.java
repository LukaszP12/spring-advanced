package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.service.ItemService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

	private static final int PAGE_SIZE = 3;

	@Autowired
	ItemService itemService;

	@RequestMapping("/")
	public List<Item> index(HttpServletResponse response) {
	/*	response.addHeader("Spring","jest super");
		Item item = new Item();
		item.setName("car");
		item.setPrice(10000);
		itemService.saveItem(item); */

		//return itemService.getItemsWithQuantityOverTwenty();
		//return itemService.findByQuantity(20);
		//return itemService.findByQuantityBetween(50,300);

		return itemService.findByQuantityGreaterThanEqualOrderByQuantityDesc(50);
	}

	@RequestMapping("/quantity_treshold")
	public List<Item> quantityThreshold(@RequestParam(name="quantity") Optional<Integer> quantityParam){
		int quantity = 50;
		if (quantityParam.isPresent()){
			quantity = quantityParam.get();
		}

		return itemService.getItemsWithQuantityOver(quantity);
	}

	@RequestMapping("/find_by_name")
	public List<Item> findByName(){
		String regexName="s%";
		List<Item> result = itemService.getItemsWithNameLike(regexName);

		return result;
	}

	@RequestMapping("/items")
	public List<Item> items(@RequestParam(defaultValue = "0") String page){
		int currentPage = Integer.parseInt(page);
		PageRequest pageRequest = PageRequest.of(currentPage, PAGE_SIZE);

		Page<Item> items = itemService.findAll(pageRequest);

		return items.getContent();
	}

}
