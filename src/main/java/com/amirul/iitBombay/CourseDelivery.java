package com.amirul.iitBombay;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CourseDelivery {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int semester;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Integer getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
