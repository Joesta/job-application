package com.telusco.JobApp.controllers;

import com.telusco.JobApp.model.JobPost;
import com.telusco.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joesta
 */

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {

        System.out.println("getAllJobs: running");
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJobById(@PathVariable(name = "id") Integer jobId) {
        System.out.println("getJobById: running: id = " + jobId);
        return jobService.getJobById(jobId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        System.out.println("addJob: running");
        jobService.addJob(jobPost);

        return jobService.getJobById(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        System.out.println("updateJob: running");
        return jobService.updateJob(jobPost);
    }

    @DeleteMapping("jobPost")
    public JobPost deleteJob(@RequestBody JobPost jobpost) {
        System.out.println("deleteJob: running");
        return jobService.deleteJob(jobpost);
    }

}
