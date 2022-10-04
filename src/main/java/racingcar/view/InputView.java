package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        validateCarNumber(carNumber);

        return carNumber;
    }

    private static void validateCarNumber(int input) {
        if (input <= 0) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }

    public static int inputTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = scanner.nextInt();

        validateTryNumber(tryNumber);

        return tryNumber;
    }

    private static void validateTryNumber(int input) {
        if (input < 0) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }
}
