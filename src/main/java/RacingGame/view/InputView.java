package RacingGame.view;

import RacingGame.common.ErrorMessageConstants;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String STAGE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError(ErrorMessageConstants.CONSTRUCTOR_ERROR_MESSAGE.getMessage());
    }

    public static String InputCarNames() {
        System.out.println(CAR_NAME_QUESTION);
        return scanner.nextLine();
    }

    public static int InputStageCount() {
        System.out.println(STAGE_COUNT_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

}
