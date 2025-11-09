package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final String INVALID_INPUT_MESSAGE = "%s은(는) 1 이상의 숫자여야 합니다.";
    private static final String NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";

    public InputView() {}

    public static RaceGameInput readRaceGameInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            int carCount = readCarCount(scanner);
            int roundCount = readRoundCount(scanner);
            return new RaceGameInput(carCount, roundCount);
        }
    }

    private static int readCarCount(Scanner scanner) {
        return readPositive(scanner, CAR_COUNT_INPUT_MESSAGE, "자동차 대수");
    }

    private static int readRoundCount(Scanner scanner) {
        return readPositive(scanner, ROUND_COUNT_INPUT_MESSAGE, "시도 횟수");
    }

    private static int readPositive(Scanner scanner, String message, String fieldName) {
        while (true) {
            try {
                print(message);
                int value = scanner.nextInt();

                if (isPositive(value)) {
                    return value;
                }

                print(String.format(INVALID_INPUT_MESSAGE, fieldName));
            } catch (Exception e) {
                print(NOT_NUMBER_MESSAGE);
                scanner.nextLine();
            }
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static boolean isPositive(int value) {
        return value >= 1;
    }
}
