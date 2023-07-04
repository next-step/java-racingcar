package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputManager.readCarNames();
        int round = InputManager.readRound();
        Cars cars = Cars.from(carNames);
        RacingManager racingManager = new RacingManager(cars, round);

        racingManager.playRacing();
    }
}
