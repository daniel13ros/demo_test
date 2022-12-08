package com.daniel.demo_test.clr;

import com.daniel.demo_test.beans.Grade;
import com.daniel.demo_test.beans.Student;
import com.daniel.demo_test.beans.Topic;
import com.daniel.demo_test.utill.BeautifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by danielR on 08/12/2022
 */
@Component
@Order(2)
public class SchoolTest implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${urlStudent}")
    private String urlStudent;

    @Override
    public void run(String... args) throws Exception {

        BeautifyUtil.headLine("school tests");

        Grade grade1 = Grade.builder()
                .topic(Topic.Project1)
                .score(69)
                .build();
        Grade grade2 = Grade.builder()
                .topic(Topic.Project2)
                .score(86)
                .build();
        Grade grade3 = Grade.builder()
                .topic(Topic.Project3)
                .score(76)
                .build();

        Grade grade4 = Grade.builder()
                .topic(Topic.Project1)
                .score(68)
                .build();
        Grade grade5 = Grade.builder()
                .topic(Topic.Project2)
                .score(79)
                .build();
        Grade grade6 = Grade.builder()
                .topic(Topic.Project3)
                .score(86)
                .build();

        Grade grade7 = Grade.builder()
                .topic(Topic.Project1)
                .score(99)
                .build();
        Grade grade8 = Grade.builder()
                .topic(Topic.Project2)
                .score(93)
                .build();
        Grade grade9 = Grade.builder()
                .topic(Topic.Project3)
                .score(96)
                .build();

        Student student1 = Student.builder()
                .name("Rita")
                .birthday(Date.valueOf(LocalDate.now().minusYears(30)))
                .grades(List.of(grade1, grade2, grade3))
                .isActive(false)
                .build();

        Student student2 = Student.builder()
                .name("Dean")
                .birthday(Date.valueOf(LocalDate.now().minusYears(18)))
                .grades(List.of(grade4, grade5, grade6))
                .isActive(true)
                .build();

        Student student3 = Student.builder()
                .name("Livnat")
                .birthday(Date.valueOf(LocalDate.now().minusYears(60)))
                .grades(List.of(grade7, grade8, grade9))
                .isActive(false)
                .build();

        BeautifyUtil.title("add student 1");
        ResponseEntity<String> res1 = restTemplate.postForEntity(urlStudent + "/students", student1, String.class);
        System.out.println(res1);
        System.out.println((res1.getStatusCodeValue() == 201) ? "OK" : "SOMETHING WENT WRONG");

        BeautifyUtil.title("add student 2");
        ResponseEntity<String> res2 = restTemplate.postForEntity(urlStudent + "/students", student2, String.class);
        System.out.println(res2);
        System.out.println((res2.getStatusCodeValue() == 201) ? "OK" : "SOMETHING WENT WRONG");

        BeautifyUtil.title("add student 3");
        ResponseEntity<String> res3 = restTemplate.postForEntity(urlStudent + "/students", student3, String.class);
        System.out.println(res3);
        System.out.println((res3.getStatusCodeValue() == 201) ? "OK" : "SOMETHING WENT WRONG");

        BeautifyUtil.title("delete student 3");
        restTemplate.postForEntity(urlStudent + "/students/8", student3, String.class);

        BeautifyUtil.title("Get all students");
        Student[] allStudents = restTemplate.getForObject(urlStudent + "/students", Student[].class);
        List<Student> students = Arrays.stream(allStudents).collect(Collectors.toList());
        students.forEach(System.out::println);

        BeautifyUtil.title("Get student 1");
        Student studentRes = restTemplate.getForObject(urlStudent + "/students/1", Student.class);
        System.out.println(studentRes);

        BeautifyUtil.title("Get all students by name");
        Student[] allNamedRick = restTemplate.getForObject(urlStudent + "/students/name?name=Rick", Student[].class);
        List<Student> namedRick = Arrays.stream(allNamedRick).collect(Collectors.toList());
        namedRick.forEach(System.out::println);

        BeautifyUtil.title("Get avg score of student 1");
        double avgOfStudent1 = restTemplate.getForObject(urlStudent + "/students/1/avg", double.class);
        System.out.println(avgOfStudent1);

    }
}
