package com.amirul.iitBombay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseDeliveryRepository extends JpaRepository<CourseDelivery, Integer> {
List<CourseDelivery> findByYearAndSemester(int year, int semester);
Optional<CourseDelivery> findByYearAndSemesterAndCourseId(int year, int semester, Integer courseId);

}
