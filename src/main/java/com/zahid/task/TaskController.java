package com.zahid.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/tasks")
public class TaskController {
    
    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping("/all")
    public ModelAndView getAllEntities() {

        List<Task> tasks = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("task/task-all");
        try {
            List<Task> fetchedTasks =  taskService.getAllEntities();
            tasks.addAll(fetchedTasks);

            log.info("tasks: {}", tasks);
            log.info("tasks.size(): {}", tasks.size());
            modelAndView.addObject("tasks", tasks);
            
        } catch (Exception e) {
            log.info("Exception: {}", e);
        }

        return modelAndView;
    }
    
    @ResponseBody
    @GetMapping("/greet")
    public String greet() {
        return "<h1>Hello Spring Boot!</h1>";
    }
}
