package com.Adzer.Green.Soloution.job.impl;

import com.Adzer.Green.Soloution.job.Jobs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class JobServiceImpl implements JobService {
    private List<Jobs> jobsList = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<Jobs> getAllJobs() {
        return jobsList;
    }

    @Override
    public void addJob(Jobs job) {
        job.setJobId(idCounter.getAndIncrement());
        jobsList.add(job);
    }

    @Override
    public Jobs getJobById(int jobId) {
        return jobsList.stream()
                .filter(job -> job.getJobId() == jobId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteJobById(int jobId) {
        return jobsList.removeIf(j -> j.getJobId() == jobId);
    }

    @Override
    public Jobs updateJob(int jobId, Jobs job) {
        for (Jobs updatedJob : jobsList) {
            if (job.getJobId() == jobId) {
                job.setJobTitle(updatedJob.getJobTitle());
                job.setJobDescription(updatedJob.getJobDescription());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                return job;
            }
        }
        return null;
    }
}
