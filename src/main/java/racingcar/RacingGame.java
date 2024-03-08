package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final List<String> roundResults = new ArrayList<>();

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RacingGame(String[] carNames) {
        this(new Cars(carNames));
    }

    public void drive(int round, DrivingStrategy drivingStrategy) {
        for (int i = 0; i < round; i++) {
            cars.drive(drivingStrategy);
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
