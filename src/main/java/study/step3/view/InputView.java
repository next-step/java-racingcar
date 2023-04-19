package study.step3.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String TEXT_INPUT_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String TEXT_INPUT_MOVE = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMINATOR = ",";
    private static final String TEXT_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표("
            + DELIMINATOR + ")를 기준으로 구분).";

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

    public String[] inputCarNames() {
        System.out.println(TEXT_INPUT_CAR_NAME);
        return splitString();
    }

    private String[] splitString() {
        String[] names = inputString().split(DELIMINATOR);
        validateNameLength(names);

        return names;
    }

    private void validateNameLength(String[] tokens) {
        for (String name : tokens) {
            int length = name.length();

            if (length > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
    }

    private String inputString() {
        return scanner.next();
    }
}
