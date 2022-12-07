package com.nest.course_backend.dao;

import com.nest.course_backend.model.Courses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends CrudRepository<Courses,Integer> {
    @Query(value = "SELECT `id`, `date`, `description`, `duration`, `title`, `venue` FROM `courses` WHERE `title`= :title" , nativeQuery = true)
    List<Courses> SearchCourses(@Param("title") String title);
}
