package step3.view;

import step3.common.ErrorMessageConstants;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String STAGE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError(ErrorMessageConstants.CONSTRUCTOR_ERROR_MESSAGE.getMessage());
    }

    public static int InputCarCount() {
        printCarQuestion();
        return Integer.parseInt(scanner.nextLine());
    }

    public static int InputStageCount() {
        printStageQuestion();
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printCarQuestion() {
        System.out.println(CAR_COUNT_QUESTION);
    }

    private static void printStageQuestion() {
        System.out.println(STAGE_COUNT_QUESTION);
    }
}
