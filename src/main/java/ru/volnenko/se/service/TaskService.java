package ru.volnenko.se.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.volnenko.se.entity.Project;
import ru.volnenko.se.entity.Task;
import ru.volnenko.se.repository.ProjectRepository;
import ru.volnenko.se.repository.TaskRepository;

/**
 * @author Denis Volnenko
 */
@Service
public class TaskService {

	@Autowired
    private TaskRepository taskRepository;

	@Autowired
    private ProjectRepository projectRepository;

	@Transactional
    public Task createTask(final String name) {
        if (name == null || name.isEmpty()) return null;
        Task t = new Task();
        t.setName(name);
        return taskRepository.save(t);
    }

    public Task getTaskById(final String id) {
        return taskRepository.getOne(Long.valueOf(id));
    }

    @Transactional
    public Task merge(final Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public void removeTaskById(final String id) {
        taskRepository.deleteById(Long.valueOf(id));
    }

    public List<Task> getListTask() {
        return taskRepository.findAll();
    }

    @Transactional
    public void clear() {
        taskRepository.deleteAll();
    }

    @Transactional
    public Task createTaskByProject(final String projectId, final String taskName) {
        Project project = projectRepository.getOne(Long.valueOf(projectId));
        if (project == null) return null;
        Task t = new Task();
        t.setName(taskName);
        t.setProject(project);
        return taskRepository.save(t);
    }

    public Task getByOrderIndex(Long id) {
    	return taskRepository.getOne(id);
    }

    @Transactional
    public void merge(Task... tasks) {
    	for (Task t : tasks) {
    		taskRepository.save(t);
    	}
    }

    @Transactional
    public void load(Task... tasks) {
    	for (Task t : tasks) {
    		taskRepository.save(t);
    	}
    }

    @Transactional
    public void load(Collection<Task> tasks) {
    	for (Task t : tasks) {
    		taskRepository.save(t);
    	}
    }

    @Transactional
    public void removeTaskByOrderIndex(Long id) {
        taskRepository.deleteById(id);
    }

}
