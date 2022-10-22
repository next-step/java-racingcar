package racing;

import java.util.Scanner;

public class RacingInputView {
    private static Scanner sc = new Scanner(System.in);
    private static String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String INPUT_GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static int inputCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return sc.nextInt();
    }

    public static int inputGameCount() {
        System.out.println(INPUT_GAME_COUNT_MESSAGE);
        return sc.nextInt();
    }
}
