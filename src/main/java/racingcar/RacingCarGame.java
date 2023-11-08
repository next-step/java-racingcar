package racingcar;

import racingcar.race.Car;
import racingcar.race.Race;
import racingcar.rule.Rule;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final int carCount;
    private final int raceCount;

    private final ResultView resultView;

    private Rule rule;

    private List<Car> cars;
    private List<Race> races;

    public RacingCarGame(int carCount, int raceCount, ResultView resultView, Rule rule) {
        this.carCount = carCount;
        this.raceCount = raceCount;

        this.resultView = resultView;

        this.rule = rule;

        this.cars = new ArrayList<>();
        this.races = new ArrayList<>();
    }

    public RacingCarGame(InputView inputView, ResultView resultView, Rule rule) {
        this(inputView.readCarCount(), inputView.readRaceCount(), resultView, rule);
    }

    public void start() {
        createCar();
        createRace();
        startRace();
    }

    public void raceResult() {
        resultView.print(races);
    }

    private void createCar() {
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            cars.add(car);
        }
    }

    private void createRace() {
        for (int i = 0; i < raceCount; i++) {
            Race race = new Race(cars, rule);
            races.add(race);
        }
    }

    private void startRace() {
        for (Race race : races) {
            race.start();
        }
    }

    public int carCount() {
        return carCount;
    }

    public int raceCount() {
        return raceCount;
    }

    public List<Car> cars() {
        return cars;
    }

    public List<Race> races() {
        return races;
    }
}
