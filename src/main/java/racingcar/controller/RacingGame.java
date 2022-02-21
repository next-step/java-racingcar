package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Times;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private RacingGame() {
    }

    public static void execute() {
        Race race = new Race(InputView.inputName());
        Times times = new Times(InputView.inputTimes());
        repeatGame(times, race);
        OutputView.printWinners(race.getWinnerNames());
    }

    private static void repeatGame(Times times, Race race) {
        while (times.isOngoing()) {
            raceOneStage(race);
            times.decrease();
        }
    }

    public static void raceOneStage(Race race) {
        List<Car> cars = race.getCars();
        for (Car car : cars) {
            race.raceOneTime(car, RandomNumberGenerator.getRandomNumber());
        }
        OutputView.printCurrentPosition(cars);
        System.out.println();
    }
}
