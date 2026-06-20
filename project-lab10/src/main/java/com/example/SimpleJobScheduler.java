package com.example;

import java.time.LocalDateTime;

public class SimpleJobScheduler implements JobScheduler {
    private Job job;
    private LocalDateTime startTime;
    private int seconds;
    private int repeat = 0;

    @Override
    public JobScheduler forJob(Job job){
        this.job = job;
        return this;
    }

    @Override
    public JobScheduler startsAt(LocalDateTime time){
        this.startTime = time;
        return this;
    }

    @Override
    public JobScheduler everySeconds(int seconds){
        this.seconds = seconds;
        return this;
    }

    @Override
    public JobScheduler repeatTimes(int times){
        this.repeat = times;
        return this;
    }

    @Override
    public void listenTo(TimeEvent event){
        if(job == null){
            return;
        }

        if(startTime == null){
            startTime = LocalDateTime.now();
        }

        if(event.getTime().isBefore(startTime)){
            return;
        }

        new JobThread(job).start();

        startTime = event.getTime().plusSeconds(seconds);

        if(repeat > 0){
            repeat--;

            if(repeat == 0){
                return;
            }
        }
    }
}