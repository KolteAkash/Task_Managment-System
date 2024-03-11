package com.example.Security.service;

import com.example.Security.model.Project;
import com.example.Security.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(projects, HttpStatus.OK);
        }
    }
    @Override
    public ResponseEntity<Project> createProject(Project project) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a zzz")
                .withZone(ZoneId.of("Asia/Kolkata"));
        String formattedDate = LocalDateTime.now().withSecond(0).format(formatter);
        Project savedProject = projectRepository.save(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<Project> getProjectById(int projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(project, HttpStatus.OK);
        }
    }
    @Override
    public ResponseEntity<Project> updateProject(int projectId, Project project) {
        Project existingProject = projectRepository.findById(projectId).orElse(null);
        if (existingProject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            existingProject.setProjectKey(existingProject.getProjectKey());
            existingProject.setProjectName(project.getProjectName());
            existingProject.setProjectType(project.getProjectType());
            existingProject.setTheme(project.getTheme());
            existingProject.setUpdatedBy(project.getUpdatedBy());
            Project updatedProject = projectRepository.save(existingProject);
            return new ResponseEntity<>(updatedProject, HttpStatus.OK);
        }
    }
    @Override
    public ResponseEntity<HttpStatus> deleteProject(int projectId) {
        try {
            projectRepository.deleteById(projectId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
