package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String RACING_GAME_START_MESSAGE = "******** 자동차 레이싱 게임 ********";
    private static final String INPUT_COUNT_OF_CAR_MESSAGE = "참가하는 자동차 대수는 몇 대 인가요?";
    private static final String INPUT_COUNT_OF_ROUND_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    private InputView() {
    }

    public static int getCountOfRacingCar() {
        System.out.println(RACING_GAME_START_MESSAGE);
        System.out.println(INPUT_COUNT_OF_CAR_MESSAGE);
        return scanner.nextInt();
    }

    public static int getCountOfRacingRound() {
        System.out.println(INPUT_COUNT_OF_ROUND_MESSAGE);
        return scanner.nextInt();
    }
}
