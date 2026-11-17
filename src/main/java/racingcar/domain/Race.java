package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        if (rounds < 0) {
            throw new IllegalArgumentException("rounds can not be negative value");
        }
        this.cars = cars;
        this.rounds = rounds;
    }

    public List<List<Integer>> play() {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            results.add(playRound());
        }
        return results;
    }

    private List<Integer> playRound() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            car.move();
            positions.add(car.getPosition());
        }
        return positions;
    }
}
