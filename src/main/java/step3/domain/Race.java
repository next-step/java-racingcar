package step3.domain;

import java.util.List;
import java.util.Random;

import step3.view.InputView;
import step3.view.ResultView;

public class Race {
    private static final int MAX_RANDOM_NUMBER = 10;
    private List<Car> racingCars;
    private int numberOfRace;

    private final Random random = new Random();

    public static void main(String[] args) {
        Race race = new Race();
        race.raceStart();
    }

    public Race() {
        prepareRace();
    }

    private void prepareRace() {
        CarFactory carFactory = new CarFactory();
        this.racingCars = carFactory.makeCars(InputView.numberOfCar());
        this.numberOfRace = InputView.numberOfRace();
    }

    public void raceStart() {
        ResultView.executionResultSign();
        for (int i = 0; i < this.numberOfRace; i++) {
            singleRace();
        }
    }

    private void singleRace() {
        for (int i = 0; i < this.racingCars.size(); i++) {
            ResultView.showDistance(racingCars.get(i).moveForward(randomNumber()));
        }
        ResultView.showNextRound();
    }

    private int randomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
