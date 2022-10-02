package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int POSITIVE_THRESHOLD_NUMBER = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String COMMA_SEPARATOR = ",";
    private static final String REQUEST = "[REQUEST] ";
    private static final String RETRY = "[RETRY MESSAGE] ";
    private static final String CAR_COUNT_QUESTION_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String TRY_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표 ','를 기준으로 구분).";
    private static final String INPUT_POSITIVE_NUMBER_MESSAGE = "1 이상의 숫자를 적어주세요.";
    private static final String INVALID_CAR_NAME_MESSAGE = "잘못 입력하여 다시 입력하세요. (" + CAR_NAME_MAX_LENGTH + "자 이하로)";

    private InputView() {
    }

    public static int inputCarCount() {
        System.out.println(REQUEST + CAR_COUNT_QUESTION_MESSAGE);
        return inputPositiveNumber();
    }

    public static int inputTryCount() {
        System.out.println(REQUEST + TRY_COUNT_QUESTION_MESSAGE);
        return inputPositiveNumber();
    }

    public static List<String> inputCarNames() {
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

    private static List<String> inputStringValue() {
        try {
            String inputValue = SCANNER.nextLine();
            return toStringList(inputValue);
        } catch (Exception e) {
            System.out.print(RETRY);
            System.out.println(e.getMessage());
            return inputStringValue();
        }
    }

    private static List<String> toStringList(String value) {
        String[] splitValues = value.split(COMMA_SEPARATOR);
        for (String splitValue : splitValues) {
            checkInvalidInputValue(splitValue);
        }
        return Arrays.asList(splitValues);
    }

    private static void checkInvalidInputValue(String value) {
        if (isBlankValue(value) || isMoreThanValueLength(value)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private static boolean isBlankValue(String value) {
        return value.isBlank();
    }

    private static boolean isMoreThanValueLength(String value) {
        return value.length() > CAR_NAME_MAX_LENGTH;
    }
}
