package racingcar.ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_NUMBER_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_NUMBER_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NOT_AN_INTEGER_MESSAGE = "입력하신 값이 정수가 아닙니다.";
    private static final String EMPTY_INPUT_MESSAGE = "입력하신 값이 비어있습니다.";
    private static final String NOT_A_POSITIVE_NUMBER_MESSAGE = "입력하신 값이 양의 정수가 아닙니다.";
    private static final String CAR_NAMES_INPUT_SPLITTER = ",";

    public static List<String> inputCarNames() {
        return input(INPUT_CAR_NAMES_QUESTION, InputView::tryCarNamesInput, InputView::isCarNamesInputValid);
    }

    public static int inputCarNumber() {
        return input(INPUT_CAR_NUMBER_QUESTION, InputView::tryInputNumber, InputView::isNumberInputValid);
    }

    public static int inputTryNumber() {
        return input(INPUT_TRY_NUMBER_QUESTION, InputView::tryInputNumber, InputView::isNumberInputValid);
    }

    private static boolean isNumberInputValid(Integer input) {
        if (input == null) {
            System.out.println(NOT_AN_INTEGER_MESSAGE);
            return false;
        }
        if (input <= 0) {
            System.out.println(NOT_A_POSITIVE_NUMBER_MESSAGE);
            return false;
        }
        return true;
    }

    private static Integer tryInputNumber() {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static List<String> tryCarNamesInput() {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        return List.of(input.split(CAR_NAMES_INPUT_SPLITTER));
    }

    private static boolean isCarNamesInputValid(List<String> input) {
        if (input == null) {
            System.out.println(EMPTY_INPUT_MESSAGE);
            return false;
        }
        return true;
    }

    private static <T> T input(String questionMessage, Supplier<T> tryInputFunction, Function<T,Boolean> inputValidationFunction) {
        boolean hasValidInput = false;
        T input = null;
        while (!hasValidInput) {
            System.out.println(INPUT_CAR_NAMES_QUESTION);
            input = tryInputFunction.get();
            hasValidInput = inputValidationFunction.apply(input);
        }
        return input;
    }

    public void close() {
        scanner.close();
    }
}
