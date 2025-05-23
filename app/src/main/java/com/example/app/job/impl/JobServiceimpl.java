package com.example.app.job.impl;

import com.example.app.job.Job;
import com.example.app.job.JobRepositary;
import com.example.app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    private JobRepositary jobRepositary;

    public JobServiceimpl(JobRepositary jobRepositary) {
        this.jobRepositary = jobRepositary;
    }


    @Override
    public List<Job> findAll() {
        return jobRepositary.findAll();
    }

    @Override
    public void addJob(Job job) {
        jobRepositary.save(job);
    }

    @Override
    public Job getJobById(Long id) {
       return jobRepositary.findById(id).orElse(null);

    }

    @Override
    public boolean deletebyId(Long id) {
        try{
            jobRepositary.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedjob) {
        Optional<Job> jobOptional = jobRepositary.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
                job.setName(updatedjob.getName());
                job.setDescription(updatedjob.getDescription());
                job.setLocation( updatedjob.getLocation());
                job.setSalary(updatedjob.getSalary());
                job.setLocation(updatedjob.getLocation());
                jobRepositary.save(job);
            return true;
        }
        return false;
    }
}
