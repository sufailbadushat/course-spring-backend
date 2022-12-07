package com.nest.course_backend.controller;


import com.nest.course_backend.dao.CourseDao;
import com.nest.course_backend.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class CourseController {


    @GetMapping("/")
    public String HomePage(){
        return "Welcome to Home Page!";
    }

    @Autowired
    private CourseDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddCourse(@RequestBody Courses courses){

        System.out.println(courses.getTitle().toString());
        System.out.println(courses.getDescription().toString());
        System.out.println(courses.getVenue().toString());
        System.out.println(courses.getDuration().toString());
        System.out.println(courses.getDate().toString());

        dao.save(courses);

        HashMap<String, String> hashMap= new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewAll")
    public List<Courses> ViewCourse(){
        return (List<Courses>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",produces = "application/json", consumes = "application/json")
    public List<Courses> searchCourse(@RequestBody Courses c){
        String title= String.valueOf(c.getTitle());
        System.out.println(title);
        return (List<Courses>) dao.SearchCourses(c.getTitle());
    }
}
