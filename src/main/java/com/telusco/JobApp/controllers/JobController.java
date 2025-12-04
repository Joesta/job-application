package com.telusco.JobApp.controllers;

import com.telusco.JobApp.model.JobPost;
import com.telusco.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joesta
 */

@Controller
public class JobController {

    @Autowired private JobService jobService;

    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @RequestMapping("viewalljobs")
    public String getAllJobs(Model model) {
        List<JobPost> jobs = jobService.getAllJobs();

        System.out.println("getAllJobs: running.....");
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }

    @RequestMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }
}
