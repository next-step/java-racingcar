package racingcar.view;

import racingcar.domain.CarName;

import java.util.Scanner;

public final class InputView {
    private static final int POSITIVE_THRESHOLD_NUMBER = 1;
    private static final String COMMA_SEPARATOR = ",";
    private static final String REQUEST = "[REQUEST] ";
    private static final String RETRY = "[RETRY MESSAGE] ";
    private static final String TRY_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표 ','를 기준으로 구분).";
    private static final String INPUT_POSITIVE_NUMBER_MESSAGE = "1 이상의 숫자를 적어주세요.";
    private static final String RETRY_INPUT_CAR_NAME_MESSAGE = "자동차 이름의 값을 다시 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputTryCount() {
        System.out.println(REQUEST + TRY_COUNT_QUESTION_MESSAGE);
        return inputPositiveNumber();
    }

    public static String inputCarNames() {
        System.out.println(REQUEST + INPUT_CAR_NAMES_MESSAGE);
        return inputStringValue();
    }

    private static int inputPositiveNumber() {
        try {
            String value = SCANNER.nextLine();
            return checkInvalidPositiveNumber(value);
        } catch (Exception e) {
            System.out.print(RETRY);
            System.out.println(e.getMessage());
            return inputPositiveNumber();
        }
    }

    private static int checkInvalidPositiveNumber(String value) {
        int intValue = toInt(value);
        if (intValue < POSITIVE_THRESHOLD_NUMBER) {
            throw new NumberFormatException(INPUT_POSITIVE_NUMBER_MESSAGE);
        }
        return intValue;
    }

    private static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new NumberFormatException(INPUT_POSITIVE_NUMBER_MESSAGE);
        }
    }

    private static String inputStringValue() {
        try {
            String input = SCANNER.nextLine();
            return validateCarName(input);
        } catch (Exception e) {
            System.out.print(RETRY);
            System.out.println(e.getMessage());
            return inputStringValue();
        }
    }

    private static String validateCarName(String input) {
        String[] carNames = input.split(COMMA_SEPARATOR);
        if (carNames.length == 0) {
            throw new IllegalArgumentException(RETRY_INPUT_CAR_NAME_MESSAGE);
        }
        for (String carName : carNames) {
            new CarName(carName);
        }
        return input;
    }
}
