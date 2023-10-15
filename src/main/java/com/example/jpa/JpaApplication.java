package com.example.jpa;

import com.example.jpa.dao.AppDAO;
import com.example.jpa.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    // executed after the Spring Beans have been loaded
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            //createInstructor(appDAO);
            //findInstructor(appDAO);
            //deleteInstructor(appDAO);
            //findInstructorDetail(appDAO);
            //deleteInstructorDetail(appDAO);
            //createInstructorWithCourses(appDAO);
            //findInstructorWithCourses(appDAO);
            //findCoursesForInstructor(appDAO);
            //findInstructorWithCoursesJoinFetch(appDAO);
            //updateInstructor(appDAO);
            //updateCourse(appDAO);
            //deleteCourse(appDAO);
            //createCourseAndReviews(appDAO);
            //retrieveCourseAndReviews(appDAO);
            //deleteCourseAndReviews(appDAO);
            //createCourseAndStudents(appDAO);
            //findCourseAndStudents(appDAO);
            //findStudentAndCourses(appDAO);
            //addMoreCoursesForStudent(appDAO);
            //deleteCourse(appDAO);
            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {

        int id = 1;
        System.out.println("Deleting student id: " + id);
        appDAO.deleteStudentById(id);
        System.out.println("Done!");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {

        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);
        Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
        Course tempCourse2 = new Course("Atari 2600 - Game Development");
        student.addCourse(tempCourse1);
        student.addCourse(tempCourse2);

        System.out.println(student);
        System.out.println(student.getCourses());
        System.out.println("Done!");

        appDAO.update(student);
    }

    private void findStudentAndCourses(AppDAO appDAO) {

        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);
        System.out.println(student);
        System.out.println(student.getCourses());
        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDAO appDAO) {

        int id = 12;
        Course course = appDAO.findCourseAndStudentsByCourseId(id);
        System.out.println(course);
        System.out.println(course.getStudents());
        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {

        Course tempCourse = new Course("Pacman2 - How to Score One Million Points");
        Student tempStudent1 = new Student("John2", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary2", "Public", "mary@luv2code.com");

        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);

        System.out.println("Saving the course");
        System.out.println("associated students: " + tempCourse.getStudents());
        System.out.println(tempCourse);

        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int id = 10;
        System.out.println("Deleting course id: " + id);
        appDAO.deleteCourseById(id);
        System.out.println("Done!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {

        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println(course);
        System.out.println(course.getReviews());
        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {

        Course tempCourse = new Course("Pacman - How to Score One Million Points");
        tempCourse.addReviews(new Review("Great course...loved it!"));
        tempCourse.addReviews(new Review("Cool course...job well done.!"));
        tempCourse.addReviews(new Review("What a dumb course, you are an idiot!"));

        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {

        int theId = 10;
        System.out.println("Deleting course id: " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {

        int theId = 10;
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);
        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Enjoy the Simple Things");
        appDAO.updateCourse(tempCourse);
        System.out.println("Done");
    }

    private void updateInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("TESTER");
        appDAO.updateInstructor(tempInstructor);
        System.out.println("Done");

    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

        int theId = 1;
        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {

        int id = 1;

        // find the instructor
        Instructor tempInstructor = appDAO.findInstructorById(id);
        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        List<Course> courses = appDAO.findCourseByInstructorId(id);

        tempInstructor.setCourses(courses);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("The courses: " + instructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Susan", "Public", "susan@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.youtube.com",
                        "Video Games");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitat - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        System.out.println("Deleting instructor detail id: " + id);
        appDAO.deleteInstructorDetailById(id);
        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 2;
        System.out.println("Finding instructor detail id: " + id);
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println("instructorDetail: " + instructorDetail);
        System.out.println("the associated instructor: " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {

        int id = 1;
        System.out.println("Deleting instructor id: " + id);
        appDAO.deleteInstructorById(id);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {

        int id = 2;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("instructor: " + instructor);
        System.out.println("the associated instructorDetail only: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu", "Darby", "darby@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Luv 2 code!!!");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");

    }
}
