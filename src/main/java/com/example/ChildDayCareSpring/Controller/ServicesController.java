package com.example.ChildDayCareSpring.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ChildDayCareSpring.Model.Services;

import com.example.ChildDayCareSpring.Repository.ServicesRepo;
import com.example.ChildDayCareSpring.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")

public class ServicesController {
    @Autowired
    private ServicesRepo servicesRepo;

    @GetMapping("/services")
    public List<Services> getAllServices(){
            return servicesRepo.findAll();
    }

    @PostMapping("/services")
    public Services addServices(@RequestBody Services services)
    {
        return servicesRepo.save(services);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Services> updateServices(@PathVariable long id, @RequestBody Services services)
    {
        Services sv1 = servicesRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        sv1.setName(services.getName());
        sv1.setDescription(services.getDescription());
        sv1.setStatus(services.getStatus());

        

        Services sv2 = servicesRepo.save(sv1);
        return ResponseEntity.ok(sv2);
    }

    //get babysitter by id
    @GetMapping("/services/{id}")
    public ResponseEntity<Services> getBabysitterById(@PathVariable long id)
    {
        Services service = servicesRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        return ResponseEntity.ok(service);

    }

    //delete babysitter
    @DeleteMapping("/services/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteService(@PathVariable long id)
    {
        Services service = servicesRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        servicesRepo.delete(service);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
