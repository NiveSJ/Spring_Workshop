package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.config.UserInputScanConfig;
import se.lexicon.data_access.StudentDAO;
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



    }
}
