package com.daniel.demo_test.services;

import com.daniel.demo_test.beans.Grade;
import com.daniel.demo_test.beans.Student;
import com.daniel.demo_test.exceptions.ErrMsg;
import com.daniel.demo_test.exceptions.SchoolCostumeException;
import com.daniel.demo_test.repos.StudentRepository;
import com.daniel.demo_test.utill.Calc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielR on 08/12/2022
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) throws SchoolCostumeException {
        if (studentRepository.existsById((long) student.getId())) {
            throw new SchoolCostumeException(ErrMsg.ID_NOT_FOUND);
        }
        studentRepository.save(student);

    }

    @Override
    public void deleteStudent(long id) throws SchoolCostumeException {
        if (!studentRepository.existsById(id)) {
            throw new SchoolCostumeException(ErrMsg.ID_NOT_FOUND);
        }
        studentRepository.deleteById(id);
        System.out.println("student deleted");
    }

    @Override
    public Student getSingleStudent(long id) throws SchoolCostumeException {
        return studentRepository.findById(id).orElseThrow(() -> new SchoolCostumeException(ErrMsg.ID_NOT_FOUND));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public double avgScoreOfSingleStudent(long id) {
        List<Grade> grades = studentRepository.findById(id).get().getGrades();
        return Calc.avgScoreCalc(grades);
    }
}
