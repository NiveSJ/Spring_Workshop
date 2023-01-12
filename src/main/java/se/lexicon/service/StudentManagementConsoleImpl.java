package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDAO;


import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.sql.SQLOutput;
import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {
  
    @Autowired
    UserInputService userInputService;

    @Autowired
    StudentDAO testStudentDAO;

    @Override
    public Student create() {
        System.out.println("Enter Student name");

        String name = userInputService.getString();
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        Student student = new Student(name);
        return student;
    }

    @Override
    public Student save(Student student) {

        return testStudentDAO.save(student);
    }

    @Override
    public Student find(int id) {

        Student foundStudent = testStudentDAO.find(id);
        return foundStudent;
    }

    @Override
    public void remove(int id) {
        // Need to ask about return type
        testStudentDAO.delete(id);

    }

    @Override
    public List<Student> findAll() {
        List<Student> AllStudents = testStudentDAO.findAll();
        return AllStudents;
    }

    @Override
    public Student edit(Student student) {
        // (20 - Test)
        // find by id
        Student updatedStudent = testStudentDAO.save(student);
        return updatedStudent;
    }
}
