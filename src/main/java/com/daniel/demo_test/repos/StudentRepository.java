package com.daniel.demo_test.repos;

import com.daniel.demo_test.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by danielR on 08/12/2022
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
}
