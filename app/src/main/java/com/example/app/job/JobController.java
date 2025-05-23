package com.example.app.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("Successful",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deletebyId(id);
        if(deleted){
            return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("NotFound",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id , @RequestBody Job updatedjob){
        boolean update = jobService.updateJob(id,updatedjob);
        if(update)
            return new ResponseEntity<>("updated succesfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

