package com.telusco.JobApp.service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.telusco.JobApp.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telusco.JobApp.repo.JobRepo;

import java.util.List;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;


    // method to add a jobPost
    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);

    }

    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }


    public JobPost getJobById(Integer jobId) {
        return repo.getJobById(jobId);
    }

    public JobPost updateJob(JobPost jobPost) {
        return repo.updateJob(jobPost);
    }

    public JobPost deleteJob(JobPost jobpost) {
        return repo.deleteJob(jobpost);
    }
}
