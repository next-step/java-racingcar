package carRacing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int readCarCount() {
        System.out.println("자동차 대수를 몇 대 인가요?");
        return isPositive(isNumber());
    }

    public static int readRaceCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return isPositive(isNumber());
    }

    private static int isPositive(int number) {
        if (number < 1) {
            throw new InputMismatchException("1 이상의 양수를 입력해 주세요");
        }
        return number;
    }

    private static int isNumber() {
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException error) {
            throw new InputMismatchException("정수를 입력해 주세요");
        }
    }

}
