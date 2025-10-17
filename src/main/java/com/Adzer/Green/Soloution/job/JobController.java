package com.Adzer.Green.Soloution.job;

import com.Adzer.Green.Soloution.job.impl.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/jobs")
    public ResponseEntity<List<Jobs>> getAllJobs() {
        List<Jobs> jobs = jobService.getAllJobs();
        if (jobs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }


    @PostMapping("/jobs")
    public ResponseEntity<String> addJob(@RequestBody Jobs job) {
        jobService.addJob(job);
        return new ResponseEntity<>("Job added successfully with ID: " + job.getJobId(), HttpStatus.CREATED);
    }


    @GetMapping("/job")
    public ResponseEntity<Jobs> getJobById(@RequestParam int id) {
        Jobs job = jobService.getJobById(id);
        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/job")
    public ResponseEntity<String> deleteJob(@RequestParam int id) {
        boolean deleted = jobService.deleteJobById(id);
        if (!deleted) return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
    }


    @PutMapping("/job")
    public ResponseEntity<?> updateJob(@RequestParam int id, @RequestBody Jobs updatedJob) {
        Jobs job = jobService.updateJob(id, updatedJob);
        if (job == null) return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }
}
