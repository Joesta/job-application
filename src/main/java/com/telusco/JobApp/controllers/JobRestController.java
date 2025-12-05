package com.telusco.JobApp.controllers;

import com.telusco.JobApp.model.JobPost;
import com.telusco.JobApp.service.JobService;
import jdk.jfr.ContentType;
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

    private JobService jobService;

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {

        System.out.println("getAllJobs: running");
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJobById(@PathVariable(name = "id") Long jobId) {
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
         jobService.deleteJob(jobpost);
         return jobService.getJobById(jobpost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJobById(@PathVariable Long id) {
        System.out.println("deleteJobById: running");
        jobService.deleteJobById(id);

        return "Deleted";
    }
    
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
        System.out.println("searchByKeyword: running " + keyword);
        return jobService.findByPostProfile(keyword);
    }

    @GetMapping("/loadJobs")
    public void saveData() {
        jobService.loadData();
    }

}
