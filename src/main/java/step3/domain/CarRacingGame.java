package step3.domain;

import step3.factory.CarFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private static final ForwardStrategy FORWARD_STRATEGY = new MoveOneForwardStrategy();

    private final List<Car> cars;
    private final int numberOfAttempts;
    private List<CarRacingRapScore> rapResults = new ArrayList<>();

    public CarRacingGame(String[] names, int numberOfAttempts) {
        this.cars = CarFactory.creates(names);
        this.numberOfAttempts = numberOfAttempts;
    }

    public void start() {
        for (int i = 0; i < numberOfAttempts; i++) {
            rapResults.add(new CarRacingRapScore(cars.stream()
                    .map(car -> car.move(FORWARD_STRATEGY))
                    .map(Car::clone)
                    .collect(Collectors.toList())));
        }
    }

    public List<CarRacingRapScore> getRapResults() {
        return rapResults;
    }

}
