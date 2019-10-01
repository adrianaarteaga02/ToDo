package ch.zli.m223.todo.repository;

import ch.zli.m223.todo.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
