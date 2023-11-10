package racingcar;

import racingcar.domain.Car;
import racingcar.race.Race;
import racingcar.race.RaceRecords;
import racingcar.rule.Rule;
import racingcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final ResultView resultView;
    private final InputView inputView;

    private final Rule rule;

    private final List<Car> cars;
    private final List<Race> races;

    public RacingCarGame(InputView inputView, ResultView resultView, Rule rule) {
        this.inputView = inputView;
        this.resultView = resultView;

        this.rule = rule;

        this.cars = new ArrayList<>();
        this.races = new ArrayList<>();

        createCar();
        createRace();
    }

    public void start() {
        for (Race race : races) {
            RaceRecords raceRecords = race.start();
        }
    }

    public void raceResult() {
        resultView.print(races);
    }

    public void winnerResult() {
        resultView.printWinner(races);
    }

    private void createCar() {
            createCarByNames((String[]) inputView.readCar());
    }

    private void createCarByNames(String[] names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void createRace() {
        createRaceByCount((Integer) inputView.readRace());
    }

    private void createRaceByCount(int count) {
        for (int i = 0; i < count; i++) {
            Race race = new Race(cars, rule);
            races.add(race);
        }
    }
}
