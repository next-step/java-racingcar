package racingcar.view;

import racingcar.domain.CarName;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_NUMBER_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_NUMBER_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NOT_AN_INTEGER_MESSAGE = "입력하신 값이 정수가 아닙니다.";
    private static final String NOT_A_POSITIVE_NUMBER_MESSAGE = "입력하신 값이 양의 정수가 아닙니다.";
    private static final String CAR_NAMES_INPUT_SPLITTER = ",";

    public static List<String> inputCarNames() {
        return input(INPUT_CAR_NAMES_QUESTION, InputView::isCarNamesInputValid, InputView::convertToCarNames);
    }

    public static int inputCarNumber() {
        return input(INPUT_CAR_NUMBER_QUESTION, InputView::isNumberInputValid, InputView::convertToNumber);
    }

    public static int inputTryNumber() {
        return input(INPUT_TRY_NUMBER_QUESTION, InputView::isNumberInputValid, InputView::convertToNumber);
    }

    private static Integer convertToNumber(String rawInput) {
        return Integer.parseInt(rawInput);
    }

    private static boolean isNumberInputValid(String rawInput) {
        if (rawInput.isEmpty()) {
            System.out.println(NOT_AN_INTEGER_MESSAGE);
            return false;
        }
        int numberInput;
        try {
            numberInput = Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            System.out.println(NOT_AN_INTEGER_MESSAGE);
            return false;
        }
        if (numberInput <= 0) {
            System.out.println(NOT_A_POSITIVE_NUMBER_MESSAGE);
            return false;
        }
        return true;
    }

    private static List<String> convertToCarNames(String rawInput) {
        return List.of(rawInput.split(CAR_NAMES_INPUT_SPLITTER));
    }

    private static boolean isCarNamesInputValid(String rawInput) {
        if (rawInput == null || rawInput.isEmpty()) {
            System.out.println(CarName.BLANK_CAR_NAME_MESSAGE);
            return false;
        }
        List<String> carNames = List.of(rawInput.split(CAR_NAMES_INPUT_SPLITTER));
        if (hasTooLongCarName(carNames)) {
            System.out.println(CarName.TOO_LONG_CAR_NAME_MESSAGE);
            return false;
        }
        return true;
    }

    private static boolean hasTooLongCarName(List<String> input) {
        boolean hasTooLongCarName = true;
        for (String carName : input) {
            hasTooLongCarName = hasTooLongCarName && CarName.isTooLong(carName);
        }
        return hasTooLongCarName;
    }

    private static <T> T input(String questionMessage, Function<String, Boolean> inputValidationFunction, Function<String, T> convertInputFunction) {
        boolean hasValidInput = false;
        T input = null;
        while (!hasValidInput) {
            System.out.println(questionMessage);
            String rawInput = scanner.nextLine();
            hasValidInput = inputValidationFunction.apply(rawInput);
            input = convertInputFunction.apply(rawInput);
        }
        return input;
    }

    public void close() {
        scanner.close();
    }
}
