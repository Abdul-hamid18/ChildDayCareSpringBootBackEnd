package com.example.ChildDayCareSpring.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ChildDayCareSpring.Model.Enrollment;
import com.example.ChildDayCareSpring.Repository.EnrollmentRepo;
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
public class EnrollmentController {
    @Autowired
    private EnrollmentRepo enrollmentRepo;




@GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollment()
    {
        return enrollmentRepo.findAll();
    }

    @PostMapping("/enrollments")
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment)
    {
        return enrollmentRepo.save(enrollment);
    }

    @PutMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable long id, @RequestBody Enrollment enrollment)
    {
        Enrollment enroll1 = enrollmentRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        enroll1.setCh_Fname(enrollment.getCh_Fname());
        enroll1.setCh_Lname(enrollment.getCh_Lname());
        enroll1.setEnroll_Date(enrollment.getEnroll_Date());
        enroll1.setCh_Gender(enrollment.getCh_Gender());
        enroll1.setPr_Fname(enrollment.getPr_Fname());
        enroll1.setPr_Lname(enrollment.getPr_Lname());
        enroll1.setPr_Gender(enrollment.getPr_Gender());
        enroll1.setPhone(enrollment.getPhone());
        enroll1.setAddress(enrollment.getAddress());
        enroll1.setEmail(enrollment.getEmail());
        enroll1.setCategory(enrollment.getCategory());



        Enrollment enroll2 = enrollmentRepo.save(enroll1);
        return ResponseEntity.ok(enroll2);
    }

    
    @GetMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> getStaffById(@PathVariable long id)
    {
        Enrollment enrollment = enrollmentRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        return ResponseEntity.ok(enrollment);
    }

    /// Get enrollment by email
    @GetMapping("/enrollments/{email}")
    public ResponseEntity<Enrollment> getEnrollmentByEmail(@PathVariable String email)
    {
        Enrollment enrollment = enrollmentRepo.findByEmail(email);
                return ResponseEntity.ok(enrollment);
    }

    
    @DeleteMapping("/enrollments/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEnrollment(@PathVariable long id)
    {
        Enrollment enrollment = enrollmentRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        enrollmentRepo.delete(enrollment);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
