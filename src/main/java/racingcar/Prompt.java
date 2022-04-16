package racingcar;

import java.util.Scanner;

public class Prompt {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] ask(String question) {
        String input;
        do {
            Printer.println(question);
            input = SCANNER.nextLine();
        } while (InputValidator.isInputWrong(input));
        return input.split(",");
    }

    public static int askAttempt(String question) {
        Printer.println(question);
        return SCANNER.nextInt();
    }
}
