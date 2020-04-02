package study.racingcar.view;

import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;
import study.racingcar.domain.GameEvent;
import study.racingcar.domain.RacingGameResult;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String CAR_DISPLAY = "-";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String START_GAME_MESSAGE = "실행 결과";

    private ResultView() {
    }

    public static void displayGameResult(RacingGameResult racingGameResult) {
        displayStartGame();

        GameEvent gameEvent = racingGameResult.getGameEvent();
        displayGameEvent(gameEvent);

        displayGameWinners(racingGameResult.getWinners());
    }

    private static void displayGameEvent(GameEvent gameEvent) {
        for (Cars cars : gameEvent) {
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

    private static void displayGameWinners(Cars winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        System.out.println(String.format(WINNER_MESSAGE,
                String.join(",", winnerNames)));
    }

    private static void displayStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }
}
