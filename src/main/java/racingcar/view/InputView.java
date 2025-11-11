package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final String NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String EMPTY_NAME_MESSAGE = "자동차 이름은 비어 있을 수 없습니다.";
    private static final String DELIMITER = ",";

    private InputView() {
        throw new AssertionError("인스턴스화를 지원하지 않습니다.");
    }

    public static RaceGameInput readRaceGameInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> carNames = readCarNames(scanner);
            int roundCount = readRoundCount(scanner);
            return new RaceGameInput(carNames, roundCount);
        }
    }

    private static List<String> readCarNames(Scanner scanner) {
        while (true) {
            println(CAR_NAMES_INPUT_MESSAGE);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                println(EMPTY_NAME_MESSAGE);
                continue;
            }

            List<String> names = splitCarNames(input);
            if (!names.isEmpty()) return names;

            println(EMPTY_NAME_MESSAGE);
        }
    }

    private static List<String> splitCarNames(String input) {
        List<String> names = new ArrayList<>();
        String[] tokens = input.split(DELIMITER);

        for (String token : tokens) {
            String name = token.trim();
            if (!name.isEmpty()) names.add(name);
        }

        return names;
    }

    private static int readRoundCount(Scanner scanner) {
        while (true) {
            try {
                println(ROUND_COUNT_INPUT_MESSAGE);
                int value = scanner.nextInt();
                if (value >= 1) return value;
                println("시도 횟수는 1 이상이어야 합니다.");
            } catch (Exception e) {
                println(NOT_NUMBER_MESSAGE);
                scanner.nextLine();
            }
        }
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
