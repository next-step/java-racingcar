package racingcar;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private StringBuilder result = new StringBuilder();

    public RacingGame(DrivingStrategy drivingStrategy, int carAmount) {
        this.cars = new Cars(drivingStrategy, carAmount);
    }

    public void drive(int round) {
        for (int i = 0; i < round; i++) {
            cars.drive();
            result.append(cars.getResult()).append("\n\n");
        }
    }

    public List<Integer> drivingDistances() {
        return cars.drivingDistances();
    }

    public String getResult() {
        return result.toString();
    }
}
