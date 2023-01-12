package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.sequencer.StudentIdGenerator;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO {

    List<Student> studentStorage = new ArrayList<>(); // e1, e2

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null");
        if (student.getId() == 0) {

            int createdId = StudentIdGenerator.nextId();
            student.setId(createdId);
            studentStorage.add(student);

        } else {
            studentStorage
                    .forEach(element ->
                    { if (element.getId() == student.getId()) element.setName(student.getName()); });

        /*    studentStorage.stream()
                    .filter(student1 -> student1.getId()==student.getId())
                    .forEach(student1 ->student1.setName(student.getName())); */

        }
        return student;
    }

    @Override
    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException("Id cannot be null");

        return studentStorage.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
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

        Student foundStudent = find(id);
        if (foundStudent.equals(null)) throw new IllegalArgumentException("No Such Student");

        studentStorage.remove(foundStudent);

    }

   /* public Student update(Student student) {

        if (student.equals(null)) throw new IllegalArgumentException("Id is null");
        Student foundStudent = find(student.getId());

        if (foundStudent.equals(null)) throw new IllegalArgumentException("No such Student found");

        foundStudent.setId(student.getId());
        foundStudent.setName(student.getName());

        return student;
    }*/
}
