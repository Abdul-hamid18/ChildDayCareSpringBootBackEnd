package com.example.ChildDayCareSpring.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.ChildDayCareSpring.Model.Babysitter;
import com.example.ChildDayCareSpring.Repository.BabysitterRepo;
import com.example.ChildDayCareSpring.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class BabysitterController {

    @Autowired
    private BabysitterRepo babysitterRepo;

    @GetMapping("/babysitters")
    public List<Babysitter> getAllBabysitters()
    {
        return babysitterRepo.findAll();
    }

    @PostMapping("/babysitters")
    public Babysitter addBabysitter(@RequestBody Babysitter babysitter)
    {
        return babysitterRepo.save(babysitter);
    }

    @PutMapping("/babysitters/{id}")
    public ResponseEntity<Babysitter> updateBabysitter(@PathVariable long id, @RequestBody Babysitter babysitter)
    {
        Babysitter babysitter1 = babysitterRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        babysitter1.setF_Name(babysitter.getF_Name());
        babysitter1.setL_Name(babysitter.getL_Name());
        babysitter1.setGender(babysitter.getGender());
        babysitter1.setAddress(babysitter.getAddress());
        babysitter1.setAge(babysitter.getAge());
        babysitter1.setPhone(babysitter.getPhone());


        Babysitter babysitter2 = babysitterRepo.save(babysitter1);
        return ResponseEntity.ok(babysitter2);
    }

    //get babysitter by id
    @GetMapping("/babysitters/{id}")
    public ResponseEntity<Babysitter> getBabysitterById(@PathVariable long id)
    {
        Babysitter babysitter = babysitterRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        return ResponseEntity.ok(babysitter);
    }

    //delete babysitter
    @DeleteMapping("/babysitters/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEnrollment(@PathVariable long id)
    {
        Babysitter babysitter = babysitterRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        babysitterRepo.delete(babysitter);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
