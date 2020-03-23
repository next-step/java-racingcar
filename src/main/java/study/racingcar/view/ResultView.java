package study.racingcar.view;

import study.racingcar.domain.Car;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RacingGameData;
import study.racingcar.controller.RandomMovableDistance;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String CAR_DISPLAY = "-";

    private static final String WINNER_DISPLAY = "%s가 최종 우승했습니다.";

    public static void printCarStatus(List<Car> carPositions) {
        String displayCar;
        for (Car car : carPositions) {
            displayCar = new String(new char[car.getPosition()])
                    .replace("\0", CAR_DISPLAY);
            System.out.println(car.getName() + ":" + displayCar);
        }

        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println(String.format(WINNER_DISPLAY, winnerNames));
    }
}
