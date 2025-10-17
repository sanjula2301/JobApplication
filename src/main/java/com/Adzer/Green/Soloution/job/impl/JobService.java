package com.Adzer.Green.Soloution.job.impl;

import com.Adzer.Green.Soloution.job.Jobs;

import java.util.List;

public interface JobService {
    List<Jobs> getAllJobs();
    void addJob(Jobs job);
    Jobs getJobById(int jobId);
    boolean deleteJobById(int jobId);
    Jobs updateJob(int jobId, Jobs job);
}

