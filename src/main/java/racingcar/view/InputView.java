package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String getCarCount() {
        System.out.println(INPUT_CAR_NAMES);
        return scanner.nextLine();
    }

    public static int getAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        return scanner.nextInt();
    }
}
