package racingcar;

import java.util.Scanner;

public class Prompt {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] ask(String question) {
        Printer.print(question);
        String input;
        input = SCANNER.nextLine();
        if (input.isBlank()) {
            System.out.println("입력 값은 빈 값이 안됩니다. 다시 입력 해주세요.");
            input = SCANNER.nextLine();
        }
        return input.split(",");
    }

    public static int askAttempt(String question) {
        Printer.print(question);
        return SCANNER.nextInt();
    }
}
