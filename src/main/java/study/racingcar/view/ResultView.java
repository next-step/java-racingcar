package study.racingcar.view;

import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;
import study.racingcar.domain.RacingGameResult;

import java.util.List;

public class ResultView {
    private static final String CAR_DISPLAY = "-";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String START_GAME_MESSAGE = "실행 결과";

    private ResultView() {
    }

    public static void displayGameResult(RacingGameResult racingGameResult) {
        displayStartGame();

        List<Cars> gameEvents = racingGameResult.getGameEvents();
        displayGameEvents(gameEvents);

        displayGameWinners(racingGameResult.getWinnerNames());
    }

    private static void displayGameEvents(List<Cars> gameEvents) {
        for (Cars cars : gameEvents) {
            displayGameStatus(cars);
        }
    }

    private static void displayGameStatus(Cars cars) {
        for (Car car : cars) {
            String displayCar = new String(new char[car.getPosition()])
                    .replace("\0", CAR_DISPLAY);
            System.out.println(car.getName() + ":" + displayCar);
        }
        System.out.println();
    }

    private static void displayGameWinners(List<String> winnerNames) {
        System.out.println(String.format(WINNER_MESSAGE,
                String.join(",", winnerNames)));
    }

    private static void displayStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }
}
