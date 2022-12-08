package com.daniel.demo_test.beans;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by danielR on 08/12/2022
 */
@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date birthday;

    private boolean isActive;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @Singular
    private List<Grade> grades;
}
