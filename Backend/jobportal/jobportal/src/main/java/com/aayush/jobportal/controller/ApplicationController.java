package com.aayush.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aayush.jobportal.model.Application;
import com.aayush.jobportal.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin("*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Apply for a job
    @PostMapping
    public Application applyJob(@RequestBody Application application){
        return applicationService.applyJob(application);
    }

    // Get all applications
    @GetMapping
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

    // Delete an application
    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id){
        applicationService.deleteApplication(id);
        return "Application deleted successfully";
    }
}