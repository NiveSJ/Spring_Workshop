package se.lexicon.Service;

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
import se.lexicon.service.StudentManagementConsoleImpl;
import se.lexicon.util.UserInputService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ComponentScanConfig.class, UserInputScanConfig.class})

public class StudentManagementConsoleImplTest {


    @Autowired
    StudentDAO testStudentDAO;

    @Autowired
    StudentManagementConsoleImpl studentManagementConsole;

    Student testStudent;

    @BeforeEach
    public void setup() {
        Student student = new Student("Nive");
        testStudent = studentManagementConsole.save(student);

    }

    @Test
    public void findAll() {
        int expectedResult = 1;
        int actualResult = studentManagementConsole.findAll().size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find() {

        Student expectedResult = testStudent;
        Student student = studentManagementConsole.find(testStudent.getId());
        assertEquals(expectedResult, student);

    }

    @Test
    public void remove() {
        assertDoesNotThrow(() -> studentManagementConsole.remove(testStudent.getId()));
    }

    @Test
    public void remove_throws_exception() {
        assertThrows(NullPointerException.class, () -> studentManagementConsole.remove(20));
    }

}
