package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String WRONG_INPUT_MESSAGE = "1이상의 정수만 입력할 수 있습니다.";
    private static final String CORRECT_INPUT_PATTERN = "[0-9]*";
    private final Scanner scanner = new Scanner(System.in);
    private static final InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public int inputCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return inputCount();
    }

    public int inputAttemptCount() {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
        return inputCount();
    }

    private int inputCount() {
        String input = scanner.next();
        validateInput(input);
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if (!input.matches(CORRECT_INPUT_PATTERN) || Integer.parseInt(input) < 1) {
            throw new IllegalStateException(WRONG_INPUT_MESSAGE);
        }
    }
}
