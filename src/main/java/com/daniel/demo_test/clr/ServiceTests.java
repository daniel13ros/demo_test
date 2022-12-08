package com.daniel.demo_test.clr;

import com.daniel.demo_test.beans.Grade;
import com.daniel.demo_test.beans.Student;
import com.daniel.demo_test.beans.Topic;
import com.daniel.demo_test.services.StudentService;
import com.daniel.demo_test.utill.BeautifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by danielR on 08/12/2022
 */
@Component
@Order(1)
public class ServiceTests implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {

        BeautifyUtil.headLine("service tests");

        Grade grade1 = Grade.builder()
                .topic(Topic.Project1)
                .score(100)
                .build();
        Grade grade2 = Grade.builder()
                .topic(Topic.Project2)
                .score(95)
                .build();
        Grade grade3 = Grade.builder()
                .topic(Topic.Project3)
                .score(90)
                .build();

        Grade grade4 = Grade.builder()
                .topic(Topic.Project1)
                .score(95)
                .build();
        Grade grade5 = Grade.builder()
                .topic(Topic.Project2)
                .score(90)
                .build();
        Grade grade6 = Grade.builder()
                .topic(Topic.Project3)
                .score(85)
                .build();

        Grade grade7 = Grade.builder()
                .topic(Topic.Project1)
                .score(100)
                .build();
        Grade grade8 = Grade.builder()
                .topic(Topic.Project2)
                .score(85)
                .build();
        Grade grade9 = Grade.builder()
                .topic(Topic.Project3)
                .score(75)
                .build();

        Grade grade10 = Grade.builder()
                .topic(Topic.Project1)
                .score(96)
                .build();
        Grade grade11 = Grade.builder()
                .topic(Topic.Project2)
                .score(92)
                .build();
        Grade grade12 = Grade.builder()
                .topic(Topic.Project3)
                .score(81)
                .build();

        Grade grade13 = Grade.builder()
                .topic(Topic.Project1)
                .score(76)
                .build();
        Grade grade14 = Grade.builder()
                .topic(Topic.Project2)
                .score(65)
                .build();
        Grade grade15 = Grade.builder()
                .topic(Topic.Project3)
                .score(86)
                .build();

        Student student1 = Student.builder()
                .name("Rick")
                .birthday(Date.valueOf(LocalDate.now().minusYears(22)))
                .grades(List.of(grade1, grade2, grade3))
                .isActive(false)
                .build();

        Student student2 = Student.builder()
                .name("Mike")
                .birthday(Date.valueOf(LocalDate.now().minusYears(18)))
                .grades(List.of(grade4, grade5, grade6))
                .isActive(true)
                .build();

        Student student3 = Student.builder()
                .name("Jessi")
                .birthday(Date.valueOf(LocalDate.now().minusYears(35)))
                .grades(List.of(grade7, grade8, grade9))
                .isActive(false)
                .build();

        Student student4 = Student.builder()
                .name("Walter")
                .birthday(Date.valueOf(LocalDate.now().minusYears(40)))
                .grades(List.of(grade10, grade11, grade12))
                .isActive(false)
                .build();

        Student student5 = Student.builder()
                .name("Merry")
                .birthday(Date.valueOf(LocalDate.now().minusYears(40)))
                .grades(List.of(grade13, grade14, grade15))
                .isActive(true)
                .build();


        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);
        studentService.addStudent(student5);

        BeautifyUtil.title("Delete student 5");
        studentService.deleteStudent(student5.getId());

        BeautifyUtil.title("Get all students");
        studentService.getAllStudents().forEach(System.out::println);

        BeautifyUtil.title("Get student 1");
        System.out.println(studentService.getSingleStudent(student1.getId()));

        BeautifyUtil.title("Get all students by name");
        studentService.getAllStudentsByName(student1.getName()).forEach(System.out::println);

        BeautifyUtil.title("Get avg score of student 1");
        System.out.println(studentService.avgScoreOfSingleStudent(student1.getId()));

    }
}
