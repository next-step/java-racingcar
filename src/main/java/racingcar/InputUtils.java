package racingcar;

import java.util.Scanner;

public class InputUtils {

    public static int getIntegerValue(Scanner scanner, String question) {
        System.out.print(question);
        readInput(scanner);
        return scanner.nextInt();
    }

    private static void readInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("숫자를 입력하세요> ");
        }
    }
}
