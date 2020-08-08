package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_OF_RACINGCAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_OF_GAME_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int setRacingCarNumber(Scanner scanner) {
        System.out.println(INPUT_OF_RACINGCAR_NUMBER);
        return scanner.nextInt();
    }

    public static int setMotorRacingCount(Scanner scanner) {
        System.out.println(INPUT_OF_GAME_COUNT);
        return scanner.nextInt();
    }

}
