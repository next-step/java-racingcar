package study.racing.ui;

import study.racing.message.ExceptionMessage;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private String[] carNames;
    private int gameCount;
    private final Scanner scanner = new Scanner(System.in);
    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_GAME_COUNT = 1;
    private static final String CAR_COUNT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public int getCarCount() {
        return carNames.length;
    }

    public int getGameCount() {
        return gameCount;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public String[] insertCar() {
        System.out.println(CAR_COUNT_MESSAGE);
        String input = this.scanner.nextLine().replaceAll("^,+|,+$", "");
        return input.split(",");
    }

    public int insertGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);
        return this.scanner.nextInt();
    }

    public void validateCar(String[] carNames) {
        boolean hasInvalidCarName = Arrays.stream(carNames).anyMatch(carName -> carName.length() > 5);
        if (hasInvalidCarName) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH_MESSAGE.getMessage());
        }

        if (carNames.length < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_COUNT_MESSAGE.getMessage());
        }
        this.carNames = carNames;
    }



    public void validateGameCount(int gameCount) {
        if (gameCount < MINIMUM_GAME_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COUNT_MESSAGE.getMessage());
        }
        this.gameCount = gameCount;
    }

}
