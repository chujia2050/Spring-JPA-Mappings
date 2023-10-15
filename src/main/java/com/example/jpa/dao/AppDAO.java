package com.example.jpa.dao;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Instructor;
import com.example.jpa.entity.InstructorDetail;
import com.example.jpa.entity.Student;

import java.util.List;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);

    public List<Course> findCourseByInstructorId(int id);

    public Instructor findInstructorByIdJoinFetch(int id);

    public void updateInstructor(Instructor tempInstructor);

    public void updateCourse(Course tempCourse);

    public Course findCourseById(int id);

    public void deleteCourseById(int id);

    public void save(Course course);

    public Course findCourseAndReviewsByCourseId(int id);

    public Course findCourseAndStudentsByCourseId(int id);

    public Student findStudentAndCoursesByStudentId(int id);

    public void update(Student student);

    public void deleteStudentById(int id);
}
