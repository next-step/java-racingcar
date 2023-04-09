package study.step3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String TEXT_INPUT_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String TEXT_INPUT_MOVE = "시도할 회수는 몇 회 인가요?";

    public int inputCountOfCar() {
        System.out.print(TEXT_INPUT_CAR);
        return inputInt();
    }

    public int inputCountOfMove() {
        System.out.print(TEXT_INPUT_MOVE);
        return inputInt();
    }

    private int inputInt() {
        try {
            int number = scanner.nextInt();
            validatePositiveInt(number);
            return number;
        } catch (InputMismatchException e) {
            throw new RuntimeException("숫자가 아닌 것은 입력할 수 없습니다.");
        }
    }

    private void validatePositiveInt(int number) {
        if (number < 0) {
            throw new IllegalStateException("음수는 입력할 수 없습니다.");
        }
    }
}
