package com.example.Security.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="Project")
public class Project {
    @PrePersist
    protected void onCreate() {
        this.created_At = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At =new Date(System.currentTimeMillis());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    @Column(unique = true)
    private String projectKey;
    private String projectName;
    private String projectType;
    private String theme;
    private Date created_At;
    private Date updated_At;
    private String createdBy;
    private String updatedBy;
}
