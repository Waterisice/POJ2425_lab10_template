package com.example;

import java.time.LocalDateTime;

public class DescribedJob implements Job {
    private String description;
    private LocalDateTime jobTime;

    public DescribedJob(String description){
        this.description = description;
    }

    @Override
    public void run() {
        System.out.println(description);
    }

    @Override
    public void setJobTime(LocalDateTime time) {
        this.jobTime = time;
    }

    @Override
    public LocalDateTime getJobTime() {
        return jobTime;
    }
}