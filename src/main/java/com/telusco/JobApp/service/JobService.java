package com.telusco.JobApp.service;

import com.telusco.JobApp.model.JobPost;
import com.telusco.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;


    public void addJob(JobPost jobPost) {
        repo.save(jobPost);

    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }


    public JobPost getJobById(Long jobId) {
        return repo.findById(jobId).orElse(new JobPost());
    }

    public JobPost updateJob(JobPost jobPost) {
        return repo.save(jobPost);
    }

    public void deleteJob(JobPost jobpost) {
        repo.delete(jobpost);
    }

    public void deleteJobById(Long id) {
        Optional<JobPost> oldJob = repo.findById(id);
        oldJob.ifPresent(jobPost -> repo.delete(jobPost));
    }

    public void loadData() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(

                new JobPost(1L, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                new JobPost(2L, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),

                new JobPost(3L, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),

                new JobPost(4L, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),

                new JobPost(5L, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));

        repo.saveAll(jobs);

    }

    public List<JobPost> findByPostProfile(String keyword) {
       return repo.findByPostProfileContainsIgnoreCaseOrPostDescContainsIgnoreCase(keyword, keyword);
    }
}
