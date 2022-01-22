package com.rashika.learningspringdatajpa.repository;
import com.rashika.learningspringdatajpa.entity.Guardian;
import com.rashika.learningspringdatajpa.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    @DisplayName("Save Student")
    @Disabled
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("rashika@gmail.com")
                .firstName("Rashika")
                .lastName("Rathnayaka")
                //.guardianName("Mrs. Pathma")
                //.guardianEmail("pathma@gmail.com")
                //.guardianMobile("+94710000000")
                .build();

        studentRepository.save(student);
    }

    @Test
    @DisplayName("Save student with guardian")
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Pathma")
                .email("pathma@gmail.com")
                .mobile("+94760000000")
                .build();


        Student student = Student.builder()
                .emailId("rashika1@gmail.com")
                .firstName("Rashika1")
                .lastName("Madhushanka1")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    @DisplayName("Print all students")
    public void printAllStudent(){

        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    @DisplayName("Find student by first name")
    public void findStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("Rashika");
        System.out.println("Students : " + students);
    }

    @Test
    @DisplayName("Find first name containing")
    public void findByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstNameContaining("Rashika");
        System.out.println("Students : " + students);
    }

    @Test
    @DisplayName("Find by guardian name")
    public void findByGuardianName(){

        List<Student> students = studentRepository.findByGuardianName("Pathma");
        System.out.println("Students : " + students);
    }

    @Test
    @DisplayName("Find by email address by query")
    public void findByEmailAddress(){

        Student student = studentRepository.getStudentByEmailAddress("rashi@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    @DisplayName("Find first name by email address by query")
    public void findFirstNameByEmailAddress(){

        String first_name = studentRepository.getStudentFirstNameByEmailAddress("rashi@gmail.com");
        System.out.println("Student's first name : " + first_name);
    }

    @Test
    @DisplayName("Get student by email native query")
    public void getStudentByEmailNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("rashika@gmail.com");
        System.out.println(student);
    }

    @Test
    @DisplayName("Get student by email native named query")
    public void getStudentByEmailNativeNamedQuery(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("rashika@gmail.com");
        System.out.println(student);
    }

    @Test
    @DisplayName("Update first name by email native query")
    public void updateStudentFirstNameByEmailId(){
        studentRepository.updateStudentFirstNameByEmailId("Rashika new new new", "rashika@gmail.com");
    }




}