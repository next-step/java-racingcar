package carracing.view;

import java.util.Scanner;

import static carracing.RacingGameSetupValidator.*;

public class InputView {
    public static final String NUMBER_OF_CARS_INPUT_GUIDE_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력으로 게임을 종료합니다.";

    private InputView() {
    }

    public static int enteredNumber(String guideMessage) {
        System.out.println(guideMessage);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!isPositiveInteger(input)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        return Integer.parseInt(input);
    }
}
