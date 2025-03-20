package racingcar.io;

import java.util.Scanner;

import racingcar.exception.InvalidInputException;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getCarCount() throws InvalidInputException {
        return readInt("자동차 대수는 몇 대 인가요?");
    }

    public int getMovementCount() throws InvalidInputException {
        return readInt("시도할 회수는 몇 회 인가요?");
    }

    public int readInt(String prompt) throws InvalidInputException {
        System.out.println(prompt);
        return validateInput();
    }

    private int validateInput() throws InvalidInputException {
        if (scanner.hasNextInt()) {
            return getPositiveNumber(scanner.nextInt());
        }

        throw new InvalidInputException("정수를 입력해 주세요.");
    }

    private int getPositiveNumber(int value) throws InvalidInputException {
        if (value > 0) {
            return value;
        }

        throw new InvalidInputException("0보다 큰 정수를 입력해 주세요.");
    }
}
