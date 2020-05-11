package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_ROUND = 1;

    private InputView() {
        throw new AssertionError();
    }

    public static int getCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);

        int carCount = scanner.nextInt();

        if(carCount < MINIMUM_CAR_COUNT){
            throw new IllegalArgumentException("최소 자동차 대수 입력 값은 " + MINIMUM_CAR_COUNT + " 입니다.");
        }
        return carCount;
    }

    public static int getGameRound() {
        System.out.println(GAME_ROUND_MESSAGE);

        int gameRound = scanner.nextInt();

        if(gameRound < MINIMUM_ROUND){
            throw new IllegalArgumentException("최소 게임 라운드 입력 값은 " + MINIMUM_ROUND + " 입니다.");
        }

        return gameRound;
    }
}