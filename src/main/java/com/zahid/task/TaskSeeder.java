package com.zahid.task;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@Order(1)
public class TaskSeeder implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        List<Task> tasks = taskService.getAllEntities();

        if (tasks.isEmpty()) {
            Task task1 = Task.builder()
                    .title("100DaysOfLeetCode")
                    .description("Solving LeetCode problems for 100 days at a stretch")
                    .time(LocalDateTime.now())
                    .build();
            Task task2 = Task.builder()
                    .title("100DaysOfGRE")
                    .description("Preparing for GRE 100 days at a stretch")
                    .time(LocalDateTime.now())
                    .build();
            Task task3 = Task.builder()
                    .title("100DaysOfFAANG")
                    .description("Preparing for FAANG interview for 100 days at a stretch")
                    .time(LocalDateTime.now())
                    .build();

            tasks.add(task1);
            tasks.add(task2);
            tasks.add(task3);

            taskService.createEntities(tasks);
        }

        log.info("Tasks: {}", tasks);
    }

}
