package racingcar.domain;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int car;
    private int attempt;
    private List<RacingCar> cars = new ArrayList<>();

    public RacingGame(int car, int attempt) {
        this.car = car;
        this.attempt = attempt;
    }

    public List<RacingCar> startGame() {
        for (int i = 0; i < car; i++) {
            cars.add(new RacingCar());
        }
        playGame();
        return cars;
    }

    private void playGame() {
        for (int i = 0; i < attempt; i++) {
            moveCars();
            ResultView.showRacingCarOutput(cars);
        }
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            car.move(new Random().nextInt(10));
        }
    }

}
