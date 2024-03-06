package racingcar;

import java.util.List;

public class RacingGame {

    private final Cars cars;

    public RacingGame(DrivingStrategy drivingStrategy, int carAmount) {
        this.cars = new Cars(drivingStrategy, carAmount);
    }

    public void drive(int round) {
        for (int i = 0; i < round; i++) {
            cars.drive();
        }
    }

    public List<Integer> drivingDistances() {
        return cars.drivingDistances();
    }
}
