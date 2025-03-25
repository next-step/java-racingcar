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

    public CarRace(int carCount, int runCount) {
        this.numberGenerator = new RandomNumberGenerator();
        this.cars = new Cars(createCars(carCount));
        this.runCount = runCount;
    }

    public CarRace(List<String> carNames, int runCount) {
        this.numberGenerator = new RandomNumberGenerator();
        this.cars = new Cars(createCars(carNames));
        this.runCount = runCount;
    }

    private List<Car> createCars(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public List<List<Integer>> run() {
        return IntStream.range(0, runCount)
                .mapToObj(i -> runOnce())
                .collect(Collectors.toList());
    }


    private List<Integer> runOnce() {
        return cars.move(numberGenerator);
    }

}

