package calculator;

import java.util.Scanner;

public class Input {

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String input(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
