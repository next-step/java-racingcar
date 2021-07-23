package racingGame;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_REPEAT_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final static Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputRepeatCount() {
        System.out.println(INPUT_REPEAT_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
