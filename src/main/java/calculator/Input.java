package calculator;

import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);

    public String getExpressionString(String message) {
        System.out.print(message);
        return this.scanner.nextLine();
    }
}
