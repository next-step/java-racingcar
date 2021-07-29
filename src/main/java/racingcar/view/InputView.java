package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_SEPARATOR = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private InputView() {
    }

    public static int getInputTryCount() {
        System.out.println(MESSAGE_INPUT_TRY_COUNT);
        return SCANNER.nextInt();
    }

    public static String[] getInputCarNames() {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);

        String input = SCANNER.next();
        emptyCheck(input);

        String[] carNames = input.split(CAR_SEPARATOR);
        validationCheck(carNames);

        return carNames;
    }

    private static void emptyCheck(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid value - input empty");
        }
    }

    private static void validationCheck(String[] carNames) {
        for (String carName : carNames) {
            validationCarNameLengthCheck(carName);
        }
    }

    private static void validationCarNameLengthCheck(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("invalid value - car name long!");
        }
    }
}
