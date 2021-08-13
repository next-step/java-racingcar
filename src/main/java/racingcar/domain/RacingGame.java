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

    public void startGame() {
        for (int i = 0; i < car; i++) {
            cars.add(new RacingCar());
        }
        playGame();
    }

    private void playGame() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            ResultView.showRacingCarOutput(cars);
        }
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            int randomNumber = getRandomNumber();
            car.move(randomNumber);
        }
    }

    private int getRandomNumber() {
        return RandomGenerator.getRandomNumber(RANDOM_NUMBER_RANGE);
    }
}
