package racingcar;

import java.util.Scanner;

public class InputView {
    private static final String ASK_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private final static Scanner scanner = new Scanner(System.in);

    public int askCarCount() {
        System.out.println(ASK_CAR_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public int askTryCount() {
        System.out.println(ASK_TRY_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }
}
