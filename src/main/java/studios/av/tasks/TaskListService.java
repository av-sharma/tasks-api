package studios.av.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskListService {
	@Autowired
	TaskListRepository taskListRepository;
	List<TaskList> taskLists = new ArrayList<TaskList>();
	private int id = 0;

	public List<TaskList> getTaskLists() {
		List<TaskList> taskLists = new ArrayList<>();
		taskListRepository.findAll().forEach(taskLists::add);

		return taskLists;
	}

	public TaskList getTask(int listId) {
		return taskListRepository.findOne(listId);
	}

	public void addTask(TaskList taskList) {
		taskListRepository.save(taskList);
	}

	public void updateTask(TaskList taskList) {
		taskListRepository.save(taskList);
	}

	public void removeTask(int listId) {
		taskListRepository.delete(listId);
	}
}
