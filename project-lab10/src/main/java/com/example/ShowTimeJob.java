package com.example;

import java.time.LocalDateTime;

public class ShowTimeJob implements Job {
    private LocalDateTime jobTime;

    public ShowTimeJob(LocalDateTime time){
        jobTime = time;
    }

    @Override
    public void run(){
        System.out.println("Aktualny czas joba: " + LocalDateTime.now());
    }

    @Override
    public void setJobTime(LocalDateTime time){
        jobTime = time;
    }

    @Override
    public LocalDateTime getJobTime(){
        return jobTime;
    }
}