package taskList.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taskList.persistence.TaskRepository;
import taskList.persistence.Task;

@Repository
public class TaskGatewaySpring {

    @Autowired
    private TaskRepository repository;

    public Iterable<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        return repository.findOne(id);
    }

    public Task addTask(String taskContent) {
        Task task = new Task(taskContent);
        repository.save(task);
        return task;
    }

    public void deleteTask(Long id) {
        repository.delete(id);
    }

    public Task changeTaskStatus(Long id, int status) {
        Task task = repository.findOne(id);
        task.setStatus(status);
        return repository.save(task);
    }


}
