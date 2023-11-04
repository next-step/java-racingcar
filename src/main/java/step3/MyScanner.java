package step3;

import java.util.Scanner;

public class MyScanner implements ScannerInterface {

    private final Scanner scanner;

    public MyScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getNext() {

        String result = scanner.next();
        scanner.close();

        return result;
    }
}
