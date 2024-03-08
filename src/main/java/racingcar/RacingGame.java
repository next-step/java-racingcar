package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final List<String> roundResults = new ArrayList<>();

    public RacingGame(DrivingStrategy drivingStrategy, String[] carNames) {
        this.cars = new Cars(drivingStrategy, carNames);
    }

    public RacingGame(Cars cars) {
        this.cars = cars;
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

    public String[] getWinnerNames() {
        return cars.getWinners().stream()
            .map(Car::name)
            .toArray(String[]::new);
    }
}
