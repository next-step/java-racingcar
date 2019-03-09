package racingcar;

import java.util.Scanner;

public class InputUtils {

    public static int getIntegerValue(Scanner scanner, String question) {
        System.out.print(question);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("에러! 숫자가 아닙니다. ");
            System.out.print(question);
        }
        return scanner.nextInt();
    }
}
