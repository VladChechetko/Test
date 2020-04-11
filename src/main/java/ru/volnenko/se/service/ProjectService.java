package ru.volnenko.se.service;

import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.entity.Project;
import ru.volnenko.se.repository.ProjectRepository;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectService implements ru.volnenko.se.api.service.IProjectService {

    private final IProjectRepository projectRepository;

    public ProjectService(final IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.createProject(name);
    }

    @Override
    public Project merge(final Project project) {
        if (project == null) return null;
        return projectRepository.merge(project);
    }

    public void merge(Collection<Project> projects) {
        projectRepository.merge(projects);
    }

    @Override
    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return projectRepository.getProjectById(id);
    }

    @Override
    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        projectRepository.removeProjectById(id);
    }

    @Override
    public List<Project> getListProject() {
        return projectRepository.getListProject();
    }

    @Override
    public void clear() {
        projectRepository.clear();
    }

    @Override
    public void merge(final Project... projects) {
        if (projects == null || projects.length == 0) return;
        projectRepository.merge(projects);
    }

    @Override
    public void load(Collection<Project> projects) {
        if (projects == null) return;
        projectRepository.load(projects);
    }

    @Override
    public void load(final Project... projects) {
        if (projects == null) return;
        projectRepository.load(projects);
    }

    @Override
    public Project removeByOrderIndex(Integer orderIndex) {
        if (orderIndex == null) return null;
        return projectRepository.removeByOrderIndex(orderIndex);
    }

}
