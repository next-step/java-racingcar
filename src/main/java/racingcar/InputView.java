package racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static RacingGameCondition inputRacingCarGameCondition() {
        return new RacingGameCondition(
                getStringWithMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
                getIntWithMessage("시도할 회수는 몇 회 인가요?"));
    }

    private static String getStringWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

    private static int getIntWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextInt();
    }
}
