package racinggame;

import racinggame.racingcar.CarName;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInputView implements InputView {
    private static final String QUESTION_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_NUMBER_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";
    private static final String ERROR_NOT_POSITIVE = "양수를 입력해주세요: ";
    private static final String ERROR_NOT_NUMBER = "숫자를 입력해주세요: ";

    private static final int ZERO = 0;
    private static final String NAME_SEPARATOR = ",";

    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public List<String> readNamesOfCars() {
        printMessage(QUESTION_NAMES_OF_CARS);
        return readValidNames();
    }

    @Override
    public int readNumberOfRounds() {
        printMessage(QUESTION_NUMBER_OF_ROUNDS);
        return readPositiveNumber();
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }

    private List<String> readValidNames() {
        try {
            List<String> names = splitNames(readInput());
            return names.stream()
                    .map(CarName::new) // CarName 객체 생성, 이름을 검증함
                    .map(CarName::getValue)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return readValidNames();
        }
    }

    private List<String> splitNames(String input) {
        return Stream.of(input.split(NAME_SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
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
