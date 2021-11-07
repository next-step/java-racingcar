package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_OUTPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_RAP_COUNT_OUTPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println(CAR_COUNT_OUTPUT_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputGameRoundCount() {
        System.out.println(GAME_RAP_COUNT_OUTPUT_MESSAGE);
        return scanner.nextInt();
    }


}
