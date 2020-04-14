package ru.volnenko.se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>  {

}
