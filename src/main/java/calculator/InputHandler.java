package calculator;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFormula() {
        System.out.println("식을 입력해 주세요.");
        return scanner.nextLine();
    }
}
