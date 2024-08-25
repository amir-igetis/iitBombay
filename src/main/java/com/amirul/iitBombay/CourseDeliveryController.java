package com.amirul.iitBombay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseDeliveryController {

    private final CourseDeliveryService courseDeliveryService;

    public CourseDeliveryController(CourseDeliveryService courseDeliveryService) {
        this.courseDeliveryService = courseDeliveryService;
    }

    @PostMapping("/instances")
    public CourseDelivery createCourseInstance(@RequestBody CourseDelivery courseDelivery) {
        return courseDeliveryService.createCourseDelivery(courseDelivery);
    }

    @GetMapping("/instances/{year}/{semester}")
    public List<CourseDelivery> getCourseInstanceByYearAndSemester(
            @PathVariable int year, @PathVariable int semester
    ) {
        return courseDeliveryService.getCourseDeliveryByYearAndSemester(year, semester);
    }

    @GetMapping("/instances/{year}/{semester}/{courseId}")
    public Optional<CourseDelivery> getCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Integer courseId) {
        return courseDeliveryService.getCourseInstance(year, semester, courseId);
    }

    @DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public void deleteCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Integer courseId) {
        courseDeliveryService.deleteCourseInstance(year, semester, courseId);
    }
}
