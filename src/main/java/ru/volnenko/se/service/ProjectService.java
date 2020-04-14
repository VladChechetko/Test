package ru.volnenko.se.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.volnenko.se.entity.Project;
import ru.volnenko.se.repository.ProjectRepository;

/**
 * @author Denis Volnenko
 */
@Service
public class ProjectService {

	@Autowired
    private ProjectRepository projectRepository;

	@Transactional
    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        Project p = new Project();
        p.setName(name);
        return projectRepository.save(p);
    }

	@Transactional
    public Project merge(final Project project) {
        if (project == null) return null;
        return projectRepository.save(project);
    }

	@Transactional
    public void merge(Collection<Project> projects) {
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return projectRepository.getOne(Long.valueOf(id));
    }

    @Transactional
    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        projectRepository.deleteById(Long.valueOf(id));
    }

    public List<Project> getListProject() {
        return projectRepository.findAll();
    }

    @Transactional
    public void clear() {
        projectRepository.deleteAll();
    }

    @Transactional
    public void merge(final Project... projects) {
        if (projects == null || projects.length == 0) return;
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    @Transactional
    public void load(Collection<Project> projects) {
        if (projects == null) return;
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    @Transactional
    public void load(final Project... projects) {
        if (projects == null) return;
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    @Transactional
    public void removeByOrderIndex(Long orderIndex) {
        if (orderIndex == null) return;
        projectRepository.deleteById(orderIndex);
    }

}
