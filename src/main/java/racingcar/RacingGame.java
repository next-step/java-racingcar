package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final List<String> roundResults = new ArrayList<>();

    public RacingGame(DrivingStrategy drivingStrategy, int carAmount) {
        this.cars = new Cars(drivingStrategy, carAmount);
    }

    public void drive(int round) {
        for (int i = 0; i < round; i++) {
            cars.drive();
            roundResults.add(cars.getResult());
        }
    }

    public List<Integer> drivingDistances() {
        return cars.drivingDistances();
    }

    public String getResult() {
        return String.join("\n\n", roundResults);
    }
}
