package com.example.ChildDayCareSpring.Repository;

import com.example.ChildDayCareSpring.Model.Enrollment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {
    Enrollment findByEmail(String email);
   
    
}
