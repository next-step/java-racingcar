package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_COUNT_QUESTION_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String TRY_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_POSITIVE_NUMBER_MESSAGE = "1 이상의 숫자를 적어주세요.";

    private InputView() {
    }

    public static int inputCarCount() {
        System.out.println(CAR_COUNT_QUESTION_MESSAGE);
        return inputPositiveNumber();
    }

    public static int inputTryCount() {
        System.out.println(TRY_COUNT_QUESTION_MESSAGE);
        return inputPositiveNumber();
    }

    private static int inputPositiveNumber() {
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            throw new NumberFormatException(INPUT_POSITIVE_NUMBER_MESSAGE);
        }
    }
}
