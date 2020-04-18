package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		return itemService.findByQuantityBetween(50,300);
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


}
