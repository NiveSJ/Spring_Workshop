package se.lexicon.DAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.config.UserInputScanConfig;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.models.Student;




import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ComponentScanConfig.class})

public class StudentDAOTest {
    @Autowired
    StudentDAO studentDAO;
    Student createdStudent;

    @BeforeEach
    public void setup() {
        Student student = new Student("Nive");
        createdStudent = studentDAO.save(student);
    }


    @Test
    public void findAll() {
        int expectedResult = 1;
        int actualResult = studentDAO.findAll().size();
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void findById() {

        Student expectedStudent = new Student(createdStudent.getId());
        Student student = studentDAO.find(createdStudent.getId());
        assertEquals(expectedStudent, student);

    }
    @Test
    public void remove() {
        assertDoesNotThrow(() -> studentDAO.delete(createdStudent.getId()));
    }

    @Test
    public void remove_throws_exception() {
        assertThrows(NullPointerException.class, () -> studentDAO.delete(20));
    }


}
