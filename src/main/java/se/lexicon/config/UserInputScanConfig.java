package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("se.lexicon")

public class UserInputScanConfig {
    @Bean
    public Scanner scanner() {

        return new Scanner(System.in);
    }

}
