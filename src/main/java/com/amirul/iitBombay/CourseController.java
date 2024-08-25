package com.amirul.iitBombay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }


    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }

//    @PostMapping("/instances")
//    public CourseInstance createCourseInstance(@RequestBody Course course) {
//
//    }
}
