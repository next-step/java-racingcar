package step3;


import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScannerTest {

    @Test
    void test() {
        Scanner scanner = new Scanner(System.in);
        assertThrows(NoSuchElementException.class, scanner::nextInt);
    }
}
