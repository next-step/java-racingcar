package racinggame.view;

import racinggame.exception.InputValueException;

import java.util.Scanner;

public final class InputView {

    private static final int MIN_INPUT_VALUE = 1;

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        validateCarNames(carNames);

        return carNames.split(",");
    }

    public static int enterRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int value = scanner.nextInt();

        validateRound(value);

        return value;
    }

    private static void validateCarNames(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InputValueException("자동차 이름을 입력하세요.");
        }
    }

    private static void validateRound(int value) {
        if (value < MIN_INPUT_VALUE) {
            throw new InputValueException("입력 값은 0 보다 커야 합니다.");
        }
    }
}
