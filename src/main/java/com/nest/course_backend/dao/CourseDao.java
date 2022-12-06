package com.nest.course_backend.dao;

import com.nest.course_backend.model.Courses;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Courses,Integer> {

}
