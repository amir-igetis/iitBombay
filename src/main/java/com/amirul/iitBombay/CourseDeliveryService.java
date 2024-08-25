package com.amirul.iitBombay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDeliveryService {

    private final CourseRepository courseRepository;

    private final CourseDeliveryRepository courseDeliveryRepository;

    public CourseDeliveryService(CourseRepository courseRepository, CourseDeliveryRepository courseDeliveryRepository) {
        this.courseRepository = courseRepository;
        this.courseDeliveryRepository = courseDeliveryRepository;
    }

    //    public CourseDelivery createCourseDelivery(CourseDelivery courseDelivery) {
//        return courseDeliveryRepository.save(courseDelivery);
//    }
//    public CourseDelivery createCourseDelivery(int year, int semester, Integer courseId) {
//        Course course = courseRepository.findById(courseId).orElseThrow(()
//                -> new RuntimeException("We don't have course with id : " + courseId));
//        CourseDelivery courseDelivery = new CourseDelivery();
//        courseDelivery.setYear(year);
//        courseDelivery.setSemester(semester);
//        courseDelivery.setCourse(course);
//
//        return courseDeliveryRepository.save(courseDelivery);
//    }

    public CourseDelivery createCourseDelivery(CourseDelivery courseDelivery) {

        if (courseDelivery.getCourse() == null || courseDelivery.getCourse().getId() == null) {
            throw new IllegalArgumentException("Course must be provided with a valid ID.");
        }

//        get the course that need to be linked with the course instance
        Integer courseId = courseDelivery.getCourse().getId();
//        now throw exception if you have not found there's no course with courseId
        Course course = courseRepository.findById(courseId).orElseThrow(()
                -> new RuntimeException("We don't have course with id : " + courseId));

//        setting the course object with course delivery instance
        courseDelivery.setCourse(course);

        return courseDeliveryRepository.save(courseDelivery);
    }


    public List<CourseDelivery> getCourseDeliveryByYearAndSemester(int year, int semester) {
        return courseDeliveryRepository.findByYearAndSemester(year, semester);
    }

    public Optional<CourseDelivery> getCourseInstance(int year, int semester, Integer courseId) {
        return courseDeliveryRepository.findByYearAndSemesterAndCourseId(year, semester, courseId);
    }

    public void deleteCourseInstance(int year, int semester, Integer courseId) {
        courseDeliveryRepository.findByYearAndSemesterAndCourseId(year, semester, courseId)
                .ifPresent(courseDelivery -> courseDeliveryRepository.delete(courseDelivery));
    }

}
