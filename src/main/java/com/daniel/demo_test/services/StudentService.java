package com.daniel.demo_test.services;

import com.daniel.demo_test.beans.Student;
import com.daniel.demo_test.exceptions.SchoolCostumeException;

import java.util.List;

/**
 * Created by danielR on 08/12/2022
 */
public interface StudentService {

    void addStudent(Student student) throws SchoolCostumeException;

    void deleteStudent(long id) throws SchoolCostumeException;

    Student getSingleStudent(long id) throws SchoolCostumeException;

    List<Student> getAllStudents();

    List<Student> getAllStudentsByName(String name);

    double avgScoreOfSingleStudent(long id);

}
