package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private static final ForwardStrategy FORWARD_STRATEGY = new RandomForwardStrategy();

    private final List<Car> cars;
    private final int numberOfAttempts;
    private List<CarRacingRapScore> rapResults = new ArrayList<>();

    public CarRacingGame(String[] names, int numberOfAttempts) {
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
        this.numberOfAttempts = numberOfAttempts;
    }

    public void start() {
        for (int i = 0; i < numberOfAttempts; i++) {
            List<Car> rapResult = cars.stream()
                    .map(car -> car.move(FORWARD_STRATEGY))
                    .map(Car::clone)
                    .collect(Collectors.toList());
            rapResults.add(new CarRacingRapScore(rapResult));
        }
    }

    public List<CarRacingRapScore> getRapResults() {
        return rapResults;
    }

}
