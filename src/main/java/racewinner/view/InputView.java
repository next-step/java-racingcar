package racewinner.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String CAR_NAME_INPUT_DESCRIPTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String RACE_ATTEMPT_DESCRIPTION = "시도할 회수는 몇 회 인가요?";

    public static String inputCarName() {
        System.out.println(CAR_NAME_INPUT_DESCRIPTION);
        return SCANNER.next();
    }

    public static int inputRaceAttemptCount() {
        System.out.println(RACE_ATTEMPT_DESCRIPTION);
        return SCANNER.nextInt();
    }
}
