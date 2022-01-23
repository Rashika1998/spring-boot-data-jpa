package com.rashika.learningspringdatajpa.repository;
import com.rashika.learningspringdatajpa.entity.Course;
import com.rashika.learningspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(60)
                .build();

        Course courseSE = Course.builder()
                .title("SE")
                .credit(50)
                .build();


        Teacher teacher = Teacher.builder()
                .firstName("Rashi")
                .lastName("Madhu")
                .courses(List.of(courseDBA, courseSE))
                .build();

        teacherRepository.save(teacher);

    }


}