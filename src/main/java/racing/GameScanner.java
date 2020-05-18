package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameScanner {

    public static int input() {
        String input;
        Scanner scanner = new Scanner(System.in);

        input = scanner.nextLine();

        if (isInteger(input)) {
            return Integer.parseInt(input);
        }

        throw new InputMismatchException("숫자를 입력해주세요.");
    }

    static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
