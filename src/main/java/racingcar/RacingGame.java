package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            roundResults.add(cars.result());
        }
    }

    public List<Integer> drivingDistances() {
        return cars.drivingDistances();
    }

    public String result() {
        return String.join("\n\n", roundResults);
    }

    public List<String> winners() {
        return cars.winners().stream()
            .map(Car::name)
            .collect(Collectors.toList());
    }
}
