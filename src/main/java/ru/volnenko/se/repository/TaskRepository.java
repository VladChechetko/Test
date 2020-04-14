package ru.volnenko.se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.volnenko.se.entity.Task;

/**
 * @author Denis Volnenko
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
