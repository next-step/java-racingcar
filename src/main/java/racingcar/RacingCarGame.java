package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceRecords;
import racingcar.rule.Rule;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
    private final ResultView resultView;
    private final InputView inputView;

    private final Rule rule;

    private final Cars cars;
    private final Races races;

    public RacingCarGame(InputView inputView, ResultView resultView, Rule rule) {
        this.inputView = inputView;
        this.resultView = resultView;

        this.rule = rule;

        this.cars = new Cars();
        this.races = new Races();

        createCar();
        createRace();
    }

    private void createCar() {
        String[] carNames = inputView.readCar();

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void createRace() {
        int raceCount = inputView.readRace();

        for (int i = 0; i < raceCount; i++) {
            Race race = new Race(cars, rule);
            races.add(race);
        }
    }

    public void start() {
        for (Race race : races.getRaces()) {
            printRaceRecord(race.start());
        }
        printWinners();
    }

    private void printRaceRecord(RaceRecords raceRecords) {
        resultView.printRaceRecords(raceRecords);
    }

    private void printWinners() {
        resultView.printWinner(races.winners());
    }
}
