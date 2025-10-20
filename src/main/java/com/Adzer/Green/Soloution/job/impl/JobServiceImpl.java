package com.Adzer.Green.Soloution.job.impl;

import com.Adzer.Green.Soloution.job.JobRepository;
import com.Adzer.Green.Soloution.job.Jobs;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Jobs> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void addJob(Jobs job) {
        jobRepository.save(job);
    }

    @Override
    public Jobs getJobById(int jobId) {
        Optional<Jobs> job = jobRepository.findById((long) jobId);
        return job.orElse(null);
    }

    @Override
    public boolean deleteJobById(int jobId) {
        if (jobRepository.existsById((long) jobId)) {
            jobRepository.deleteById((long) jobId);
            return true;
        }
        return false;
    }

    @Override
    public Jobs updateJob(int jobId, Jobs updatedJob) {
        return jobRepository.findById((long) jobId).map(existingJob -> {
            existingJob.setJobTitle(updatedJob.getJobTitle());
            existingJob.setJobDescription(updatedJob.getJobDescription());
            existingJob.setMaxSalary(updatedJob.getMaxSalary());
            existingJob.setMinSalary(updatedJob.getMinSalary());
            existingJob.setLocation(updatedJob.getLocation());
            return jobRepository.save(existingJob);
        }).orElse(null);
    }
}
