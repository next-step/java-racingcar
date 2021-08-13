package racingcar.domain;

import racingcar.util.RandomGenerator;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final static int RANDOM_NUMBER_RANGE = 10;

    private int car;
    private int attempts;
    private List<RacingCar> cars = new ArrayList<>();

    public RacingGame(int car, int attempts) {
        this.car = car;
        this.attempts = attempts;
    }

    public List<RacingCar> playGame() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
        }
        return cars;
    }

    public void readGame() {
        for (int i = 0; i < car; i++) {
            cars.add(new RacingCar());
        }
        playGame();
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            moveOrStopCar(car);
        }
        ResultView.showRacingCarOutput(cars);
    }

    private void moveOrStopCar(RacingCar car) {
        int randomInt = getRandomInt();
        car.move(randomInt);
    }

    private int getRandomInt() {
        return RandomGenerator.getRandomNumber(RANDOM_NUMBER_RANGE);
    }
}
