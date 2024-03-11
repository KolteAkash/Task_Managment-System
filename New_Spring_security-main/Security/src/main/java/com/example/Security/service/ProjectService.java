package com.example.Security.service;
import com.example.Security.model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    ResponseEntity<List<Project>> getAllProjects();
    ResponseEntity<Project> createProject(Project project);
    ResponseEntity<Project> getProjectById(int projectId);
    ResponseEntity<Project> updateProject(int projectId, Project project);
    ResponseEntity<HttpStatus> deleteProject(int projectId);
}
