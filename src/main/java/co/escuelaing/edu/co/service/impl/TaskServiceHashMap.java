package co.escuelaing.edu.co.service.impl;

import co.escuelaing.edu.co.entities.Task;
import co.escuelaing.edu.co.service.TaskService;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskServiceHashMap implements TaskService {

    private static final AtomicInteger contTask = new AtomicInteger(1);
    private final HashMap<String, Task> taskHashMap;

    public TaskServiceHashMap(HashMap<String, Task> taskHashMap) {
        this.taskHashMap = taskHashMap;
    }

    @Override
    public Task create(Task task) {
        task.setId(String.valueOf(contTask.getAndIncrement()));
        taskHashMap.put(task.getId(),task);
        return task;
    }

    @Override
    public Task findById(String id) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public Task update(Task task, String id) {
        return null;
    }
}
