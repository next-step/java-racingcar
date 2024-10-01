package study.racing.ui;

import study.racing.message.ExceptionMessage;

import java.util.Scanner;

public class InputView {

    private int carCount;
    private int gameCount;
    private final Scanner scanner = new Scanner(System.in);
    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_GAME_COUNT = 1;
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int insertCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return getCount();
    }

    public int insertGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);
        return getCount();
    }

    public void validateCarCount(int carCount) {
        if (carCount < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_COUNT_MESSAGE.getMessage());
        }
        this.carCount = carCount;
    }

    public void validateGameCount(int gameCount) {
        if (gameCount < MINIMUM_GAME_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COUNT_MESSAGE.getMessage());
        }
        this.gameCount = gameCount;
    }

    private int getCount() {
        return this.scanner.nextInt();
    }

}
