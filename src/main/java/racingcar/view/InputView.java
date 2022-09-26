package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askQuestion(String question) {
        printQuestion(question);
        return readAnswer(scanner);
    }

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    private static String readAnswer(Scanner scanner) {
        return scanner.nextLine();
    }
}
