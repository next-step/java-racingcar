package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {
    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final int runCount;

    public CarRace(List<Car> cars, int runCount) {
        this.numberGenerator = new RandomNumberGenerator();
        this.cars = new Cars(cars);
        this.runCount = runCount;
    }

    public List<List<Integer>> run() {
        return IntStream.range(0, runCount)
                .mapToObj(i -> runOnce())
                .collect(Collectors.toList());
    }

    private List<Integer> runOnce() {
        return cars.move(numberGenerator);
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}

