package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static int inputCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);

        return input();
    }

    public static int inputGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);

        return input();
    }

    private static int input() {
        return SCANNER.nextInt();
    }
}
