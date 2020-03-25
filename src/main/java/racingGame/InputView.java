package racingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static int input;

    public static int cars() {
        return inputValidator();
    }

    public static int rounds() {
        return inputValidator();
    }

    public static int inputValidator() {
        try {
            input = isGreaterThan0(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력가능합니다.");
            scanner.close();
        } finally {

        }
        return input;
    }

    public static int isGreaterThan0(int input) {
        if (input < 1) {
            System.out.println("1이상의 숫자를 입력해 주세요");
            scanner.close();
        }
        return input;
    }

}
