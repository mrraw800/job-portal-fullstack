package com.aayush.jobportal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.jobportal.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}

