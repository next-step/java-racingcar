package racingcar;

import racingcar.domain.Car;
import racingcar.race.Cars;
import racingcar.race.Race;
import racingcar.race.RaceRecords;
import racingcar.rule.Rule;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final ResultView resultView;
    private final InputView inputView;

    private final Rule rule;

    private final Cars cars;
    private final List<Race> races;

    public RacingCarGame(InputView inputView, ResultView resultView, Rule rule) {
        this.inputView = inputView;
        this.resultView = resultView;

        this.rule = rule;

        this.cars = new Cars();
        this.races = new ArrayList<>();


        String[] carNames = inputView.readCar();
        int raceCount = inputView.readRace();

        createCar(carNames);
        createRace(raceCount);
    }

    private void createCar(String[] carNames) {
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void createRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            Race race = new Race(cars, rule);
            races.add(race);
        }
    }

    public void start() {
        for (Race race : races) {
            printRaceResult(race.start());
        }
        printWinners();
    }

    private void printRaceResult(RaceRecords raceRecords) {
        resultView.printRaceRecords(raceRecords);
    }

    private void printWinners() {
        resultView.printWinner(races);
    }
}
