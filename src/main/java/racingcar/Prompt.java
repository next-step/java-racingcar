package racingcar;

import java.util.Scanner;

public class Prompt {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] ask(String question) {
        Printer.println(question);
        String input = SCANNER.nextLine();
        InputValidator.validateBlank(input);

        String[] carNames = input.split(",");
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public static int askAttempt(String question) {
        Printer.println(question);
        return SCANNER.nextInt();
    }
}
