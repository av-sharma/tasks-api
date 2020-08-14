package studios.av.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskListController {
	@Autowired
	private TaskListService taskListService;

	@RequestMapping("/lists")
	public List<TaskList> getAllTasks() {
		return taskListService.getTaskLists();
	}

	@RequestMapping("/lists/{listId}")
	public TaskList getTask(@PathVariable int listId) {
		return taskListService.getTask(listId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/lists")
	public void addTask(@RequestBody TaskList taskList) {
		taskListService.addTask(taskList);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lists/{listId}")
	public void updateTask(@RequestBody TaskList taskList) {
		taskListService.updateTask(taskList);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/lists/{listId}")
	public void removeTask(@PathVariable int listId) {
		taskListService.removeTask(listId);
	}
}
