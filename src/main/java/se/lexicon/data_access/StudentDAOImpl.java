package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.sequencer.StudentIdGenerator;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO {

    List<Student> studentStorage = new ArrayList<>();

    @Override
    public Student save(Student student) {

        if (student.equals(null)) throw new IllegalArgumentException("Student cannot be null");
        Student foundName = findByName(student.getName());

        if (foundName != null) throw new IllegalArgumentException("Student Already present cannot insert");
        int createdId = StudentIdGenerator.nextId();


        student.setId(createdId);
        studentStorage.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException("Id cannot be null");

        return studentStorage.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentStorage);
    }

    public Student findByName(String name) {
        if (name.equals(null)) throw new IllegalArgumentException("Id cannot be null");

        return studentStorage.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);


    }


    @Override
    public void delete(int id) {
        if (id == 0) throw new IllegalArgumentException("Id cannot be null");

        Student foundstudent = find(id);
        if (foundstudent.equals(null)) throw new IllegalArgumentException("No Such Student");

        studentStorage.remove(foundstudent);

    }

    public Student update(Student student) {

        if (student.equals(null)) throw new IllegalArgumentException("Id is null");
        Student foundStudent = find(student.getId());

        if (foundStudent.equals(null)) throw new IllegalArgumentException("No such Student found");

        foundStudent.setId(student.getId());
        foundStudent.setName(student.getName());

        return student;
    }
}
