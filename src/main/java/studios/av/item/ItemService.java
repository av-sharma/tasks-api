package studios.av.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	List<Item> items = new ArrayList<Item>();
	private int id = 0;

	public List<Item> getItems(int id) {
		List<Item> items = new ArrayList<>();
		itemRepository.findByTaskListId(id).forEach(items::add);

		return items;
	}

	public Item getItem(int id) {
//		itemRepository.findById(id);
		return itemRepository.findOne(id);
	}

	public void addItem(Item item) {
		item.setId(id++);
		itemRepository.save(item);
	}

	public void updateItem(Item item, int id) {
		item.setId(id);
		itemRepository.save(item);
	}

	public void removeItem(int id) {
		itemRepository.delete(id);
	}
}
