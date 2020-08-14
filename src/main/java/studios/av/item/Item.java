package studios.av.item;

import studios.av.tasks.TaskList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	private int id;
	private String name;
	private String dueDate;
	private String description;
	@ManyToOne
	private TaskList taskList;

	public Item() {
	}

	public Item(String name, String dueDate, String description, int listId) {
		this.name = name;
		this.dueDate = dueDate;
		this.description = description;
		this.taskList = new TaskList(listId, "", "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public TaskList getTask() {
		return taskList;
	}

	public void setTask(TaskList taskList) {
		this.taskList = taskList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
