package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {
    private final int runCount;
    private final Cars cars;

    public CarRace(int carCount, int runCount) {
        this.runCount = runCount;
        this.cars = new Cars(createCars(carCount));
    }

    private List<Car> createCars(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public List<List<Integer>> run() {
        return IntStream.range(0, runCount)
                .mapToObj(i -> runOnce())
                .collect(Collectors.toList());
    }

    private List<Integer> runOnce() {
        return cars.move();
    }

}

