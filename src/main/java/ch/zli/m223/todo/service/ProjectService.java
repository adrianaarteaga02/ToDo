package ch.zli.m223.todo.service;

import ch.zli.m223.todo.domain.Project;
import ch.zli.m223.todo.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    private Optional<Project> findProjectById(long id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.saveAndFlush(project);
    }

    public void deleteProjectById(long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
    }

    public Project updateProject(Project project, Long id) {
        Project updatedProject;
        Optional<Project> optionalUpdatedProject = findProjectById(id);

        if (optionalUpdatedProject.isPresent()) {
            updatedProject = optionalUpdatedProject.get();
            updatedProject.setName(project.getName());
            updatedProject.setDescription(project.getDescription());
            updatedProject.setUser(project.getUser());
        } else {
            updatedProject = project;
            updatedProject.setId(id);
        }
        return projectRepository.saveAndFlush(updatedProject);
    }
}
