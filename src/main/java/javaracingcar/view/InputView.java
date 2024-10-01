package javaracingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String DEFAULT_REQUIRE_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?\n";
    private static final String DEFAULT_REQUIRE_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?\n";

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static final int requireCarCount() {
        System.out.print(DEFAULT_REQUIRE_CAR_MESSAGE);
        return scanner.nextInt();
    }

    public static int requireTryCount() {
        System.out.print(DEFAULT_REQUIRE_TRY_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
