package study.racingcar.view;

import study.racingcar.domain.Car;
import study.racingcar.domain.RacingGame;

public class ResultView {
    private static final String CAR_DISPLAY = "-";

    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";
    private static final String START_GAME_MESSAGE = "실행 결과";

    public static void displayGameStatus(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            String displayCar = new String(new char[car.getPosition()])
                    .replace("\0", CAR_DISPLAY);
            System.out.println(car.getName() + ":" + displayCar);
        }
        System.out.println();
    }

    public static void displayWinners(String winnerNames) {
        System.out.println(String.format(WINNER_MESSAGE, winnerNames));
    }

    public static void displayInvalidInputError() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    public static void displayStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }
}
