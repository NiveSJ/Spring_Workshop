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
        return new Student(name);
    }

    @Override
    public Student save(Student student) {

        return testStudentDAO.save(student);
    }

    @Override
    public Student find(int id) {

        return testStudentDAO.find(id);
    }

    @Override
    public void remove(int id) {
        // Need to ask about return type
        testStudentDAO.delete(id);

    }

    @Override
    public List<Student> findAll() {
        return testStudentDAO.findAll();
    }

    @Override
    public Student edit(Student student) {

        if (find(student.getId()) == null) throw new IllegalArgumentException("No such student to update");
        return testStudentDAO.save(student);
    }
}
