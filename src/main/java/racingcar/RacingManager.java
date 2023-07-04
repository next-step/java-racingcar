package racingcar;

import java.util.List;

public class RacingManager {

    private final Cars cars;
    private final int round;

    public RacingManager(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingManager of(List<String> carNames, int round) {
        return new RacingManager(Cars.from(carNames), round);
    }

    public void playRacing() {
        for (int i = 0; i < round; i++) {
            cars.takeTurn();
        }
    }
}
