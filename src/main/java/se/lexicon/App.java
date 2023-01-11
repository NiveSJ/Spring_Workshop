package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.config.UserInputScanConfig;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagementConsoleImpl;
import se.lexicon.util.ScannerInputService;

/**
 * Spring Workshop
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDAO studentDao = context.getBean(StudentDAO.class);


        AnnotationConfigApplicationContext userInputContext =
                new AnnotationConfigApplicationContext(UserInputScanConfig.class);

        ScannerInputService scan = userInputContext.getBean(ScannerInputService.class);

        StudentManagementConsoleImpl studentManagementConsole = context.getBean(StudentManagementConsoleImpl.class);

        Student createdStudent = studentManagementConsole.create();
        Student createdStudent1 = studentManagementConsole.create();

        studentManagementConsole.save(createdStudent);
        studentManagementConsole.save(createdStudent1);


        System.out.println("\n >>Find Student by id  " + studentManagementConsole.find(createdStudent.getId()));

        System.out.println("\n >>Find All");
        studentManagementConsole.findAll().forEach(System.out::println);

        System.out.println("\n >>Update Student");

        createdStudent1.setName("TestTest");
        studentManagementConsole.edit(createdStudent1);
        System.out.println(" >>updated Student: " + studentManagementConsole.find(createdStudent1.getId()));


        System.out.println("\n >>Remove Student by id");
        studentManagementConsole.remove(createdStudent.getId());

        System.out.println("\n >> checking removed Student");
        System.out.println(studentManagementConsole.find(createdStudent.getId()));


    }
}
