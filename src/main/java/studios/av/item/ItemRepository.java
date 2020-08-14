package studios.av.item;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	public List<Item> findByTaskListId(int taskId);
}
