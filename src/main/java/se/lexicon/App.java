package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.data_access.StudentDAO;

/**
 * Spring Workshop
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDAO studentDAO = context.getBean(StudentDAO.class);


        System.out.println("Hello World!");
    }
}
