package java_racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int carNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        return inputIntValue();
    }

    public static int racingTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        return inputIntValue();
    }

    private static int inputIntValue() {
        String inputNumber = scanner.nextLine();
        if (!inputNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
        return Integer.parseInt(inputNumber);
    }
}
