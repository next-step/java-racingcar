package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;
    private List<RoundResult> roundResults;

    public Race(List<Car> cars, int rounds) {
        if (rounds < 0) {
            throw new IllegalArgumentException("rounds can not be negative value");
        }
        this.cars = cars;
        this.rounds = rounds;
        this.roundResults = new ArrayList<>();
    }

    public Race(int carCount, int rounds, MoveStrategy moveStrategy) {
        this(createCars(carCount, moveStrategy), rounds);
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    private static List<Car> createCars(int carCount, MoveStrategy moveStrategy) {
        if (carCount < 0) {
            throw new IllegalArgumentException("car count can not be negative value");
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(moveStrategy));
        }
        return cars;
    }

    public void play() {
        roundResults = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            roundResults.add(playRound());
        }
    }

    private RoundResult playRound() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            car.move();
            positions.add(car.getPosition());
        }
        return new RoundResult(positions);
    }
}
