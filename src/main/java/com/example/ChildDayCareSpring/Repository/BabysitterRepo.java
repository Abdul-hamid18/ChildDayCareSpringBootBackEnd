package com.example.ChildDayCareSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ChildDayCareSpring.Model.Babysitter;

public interface BabysitterRepo extends JpaRepository<Babysitter,Long> {
    
}
