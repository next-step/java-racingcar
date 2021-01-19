package caculator;

import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);

    public String input(String message) {
        System.out.print(message);
        return this.scanner.nextLine();
    }
}
