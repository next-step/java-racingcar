package step3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String NOT_NUMBER_FORMAT_MESSAGE = "전달 값의 숫자 이외의 값이 포함되어 있습니다.";
    private static final String NOT_POSITIVVE_MESSAGE = "음수가 포함되어 있습니다.";

    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return inputNumber();
    }

    public int inputMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputNumber();
    }

    private static int inputNumber() {
        try {
            int number = scanner.nextInt();
            if (number < 0) {
                throw new RuntimeException(NOT_POSITIVVE_MESSAGE);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_NUMBER_FORMAT_MESSAGE);
        }
    }
}
