package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static int requestInputCount() {
        return requestPositiveNumber("자동차 대 수는 몇 대 인가요?");
    }

    public static int requestInputRepeat() {
        return requestPositiveNumber("시도할 회수는 몇 회 인가요?");
    }

    private static int requestPositiveNumber(String message) {
        System.out.println(message);
        int number = 0;

        try {
            number = scanNumber();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 문자가 입력되었습니다.");
            System.exit(1);
        }

        if (number < 1) {
            System.out.println("너무 작은 숫자를 입력했습니다");
            System.exit(1);
        }

        System.out.println();
        return number;
    }

    private static int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
