package racinggame;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_NUMBER_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";
    private static final String ERROR_NOT_POSITIVE = "양수를 입력해주세요: ";
    private static final String ERROR_NOT_NUMBER = "숫자를 입력해주세요: ";
    private static final int ZERO = 0;

    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int readNumberOfCars() {
        printMessage(QUESTION_NUMBER_OF_CARS);
        return readPositiveNumber();
    }

    @Override
    public int readNumberOfRounds() {
        printMessage(QUESTION_NUMBER_OF_ROUNDS);
        return readPositiveNumber();
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }

    private int readPositiveNumber() {
        String input = readInput();
        try {
            int number = parseNumber(input);
            validatePositiveNumber(number);
            return number;
        } catch (RuntimeException e) {
            System.out.print(e.getMessage());
            return readPositiveNumber(); // 재귀적 호출
        }
    }

    private String readInput() {
        return scanner.nextLine();
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(ERROR_NOT_NUMBER + input);
        }
    }

    private void validatePositiveNumber(int number) {
        if (isNegativeOrZero(number)) {
            throw new RuntimeException(ERROR_NOT_POSITIVE + number);
        }
    }

    private boolean isNegativeOrZero(int number) {
        return number <= ZERO;
    }
}
