package racingcar;

import racingcar.race.Car;
import racingcar.race.Race;
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
    }

    public void start() {
        createCar();
        createRace();
        startRace();
    }

    public void raceResult() {
        resultView.print(races);
    }

    public void winnerResult() {
        resultView.printWinner(races);
    }

    private void createCar() {
        if (isCountView()) {
            createCarByCount((Integer) inputView.readCar());
        }

        if (isStringView()) {
            createCarByNames((String[]) inputView.readCar());
        }
    }

    private void createCarByCount(int count) {
        for (int i = 0; i < count; i++) {
            Car car = new Car();
            cars.add(car);
        }
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

    private boolean isStringView() {
        return inputView instanceof InputStringView;
    }

    private boolean isCountView() {
        return inputView instanceof InputCountView
                || inputView instanceof CountView;
    }

    private void startRace() {
        for (Race race : races) {
            race.start();
        }
    }

    public int carCount() {
        return cars.size();
    }

    public int raceCount() {
        return races.size();
    }

    public List<Car> cars() {
        return cars;
    }

    public List<Race> races() {
        return races;
    }
}
