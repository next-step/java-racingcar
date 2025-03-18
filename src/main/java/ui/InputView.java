package ui;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer queryIntegerInputWithPrompt(String question) {
        System.out.print(question);
        return scanner.nextInt();
    }
}
