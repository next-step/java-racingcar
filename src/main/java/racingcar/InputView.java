package racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static RacingGameCondition inputRacingCarGameCondition() {
        return new RacingGameCondition(
                getIntWithMessage("자동차 대수는 몇 대 인가요?"),
                getIntWithMessage("시도할 회수는 몇 회 인가요?"));
    }

    private static int getIntWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextInt();
    }
}
