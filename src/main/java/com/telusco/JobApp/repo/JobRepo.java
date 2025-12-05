package com.telusco.JobApp.repo;

import com.telusco.JobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Long> {

    List<JobPost> findByPostProfileContainsIgnoreCaseOrPostDescContainsIgnoreCase(String postProfile, String postDesc);
}
