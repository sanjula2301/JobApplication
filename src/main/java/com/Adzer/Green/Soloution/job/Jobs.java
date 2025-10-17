package com.Adzer.Green.Soloution.job;

public class Jobs {

    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private int maxSalary;
    private int minSalary;
    private String location;

    public Jobs(int jobId, String jobTitle, String jobDescription, int maxSalary, int minSalary, String location) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.location = location;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                ", location='" + location + '\'' +
                '}';
    }
}

