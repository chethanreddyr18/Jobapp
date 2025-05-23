package com.example.app.job;

import java.util.*;

public interface JobService {
  List<Job> findAll();
   void addJob(Job job);

    Job getJobById(Long id);

    boolean deletebyId(Long id);

    boolean updateJob(Long id, Job updatedjob);
}
