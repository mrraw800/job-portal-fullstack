package com.aayush.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aayush.jobportal.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}