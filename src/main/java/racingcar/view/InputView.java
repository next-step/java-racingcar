package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputView {
    private static final String SEPARATOR = ",";
    private static final String REQUEST = "[REQUEST] ";
    private static final String RETRY = "[RETRY MESSAGE] ";
    private static final String TRY_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표 ','를 기준으로 구분).";
    private static final String INPUT_POSITIVE_NUMBER_MESSAGE = "1 이상의 숫자를 적어주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputTryCount() {
        System.out.println(REQUEST + TRY_COUNT_QUESTION_MESSAGE);
        return inputPositiveNumber();
    }

    public static List<String> inputCarNames() {
        System.out.println(REQUEST + INPUT_CAR_NAMES_MESSAGE);
        return toList(splitToArray(inputValue()));
    }

    private static int inputPositiveNumber() {
        try {
            return toInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.print(RETRY);
            System.out.println(e.getMessage());
            return inputPositiveNumber();
        }
    }

    private static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new NumberFormatException(INPUT_POSITIVE_NUMBER_MESSAGE);
        }
    }

    private static List<String> toList(String[] carNamesArray) {
        return Arrays.asList(carNamesArray);

    }

    private static String[] splitToArray(String carNames) {
        return carNames.trim().split(SEPARATOR);
    }

    private static String inputValue() {
            return SCANNER.nextLine();
    }
}
