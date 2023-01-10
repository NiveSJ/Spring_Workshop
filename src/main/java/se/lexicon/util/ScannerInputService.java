package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    @Autowired
    Scanner scanner;

    @Override
    public String getString() {
        return null;
    }

    @Override
    public int getInt() {
        return 0;
    }
}
