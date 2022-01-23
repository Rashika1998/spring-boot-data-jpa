package com.rashika.learningspringdatajpa.repository;
import com.rashika.learningspringdatajpa.entity.Course;
import com.rashika.learningspringdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("DSA")
                .credit(80)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("https://www.hackerrank.com/dashboard")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){

        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("Course materials: " + courseMaterials);

    }



}