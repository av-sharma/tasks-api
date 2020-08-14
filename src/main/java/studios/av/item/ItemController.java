package studios.av.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studios.av.tasks.TaskList;

import java.util.List;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/lists/{listId}/items")
	public List<Item> getAllItems(@PathVariable int listId) {
		return itemService.getItems(listId);
	}

	@RequestMapping("/lists/{listId}/items/{itemId}")
	public Item getItem(@PathVariable int listId) {
		return itemService.getItem(listId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/lists/{listId}/items")
	public void addItem(@RequestBody Item item, @PathVariable int listId) {
		item.setTask(new TaskList(listId, "", ""));
		itemService.addItem(item);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lists/{listId}/items/{itemId}")
	public void updateItem(@RequestBody Item item, @PathVariable int listId, @PathVariable int itemId) {
		item.setTask(new TaskList(listId, "",  ""));
		itemService.updateItem(item, itemId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/lists/{listId}/items/{itemId}")
	public void removeTask(@PathVariable int itemId) {
		itemService.removeItem(itemId);
	}
}
