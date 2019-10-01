package ch.zli.m223.todo.controller;

import ch.zli.m223.todo.domain.Project;
import ch.zli.m223.todo.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllEntries() {
        return projectService.findAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@Valid @RequestBody Project project) {
        return projectService.createProject(project);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProjectById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@Valid @RequestBody Project project, @PathVariable Long id) {
        return projectService.updateProject(project, id);
    }
}