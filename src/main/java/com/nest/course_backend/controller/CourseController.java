package com.nest.course_backend.controller;


import com.nest.course_backend.model.Courses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CourseController {

    @GetMapping("/")
    public String HomePage(){
        return "Welcome to Home Page!";
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String AddCourse(@RequestBody Courses courses){

        System.out.println(courses.getTitle().toString());
        System.out.println(courses.getDescription().toString());
        System.out.println(courses.getVenue().toString());
        System.out.println(courses.getDuration().toString());
        System.out.println(courses.getDate().toString());
        return "Course added successfully!";
    }
}
