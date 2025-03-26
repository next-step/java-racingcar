package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {
    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final int runCount;

    public CarRace(List<Car> cars, int runCount, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.cars = new Cars(cars);
        this.runCount = runCount;
    }

    public List<List<CarState>> run() {
        return IntStream.range(0, runCount)
                .mapToObj(i -> runOnce())
                .collect(Collectors.toList());
    }

    private List<CarState> runOnce() {
        return cars.move(numberGenerator);
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}

