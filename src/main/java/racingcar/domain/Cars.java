package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount) {
        cars = new ArrayList<>();
        createCars(carCount);
    }

    public Scores move(NumberGeneratorStrategy numberGeneratorStrategy) {
        Scores scores = new Scores();
        for (Car car : cars) {
            car.move(numberGeneratorStrategy);
            scores.addScore(car);
        }
        return scores;
    }

    public int findCarsCount() {
        return cars.size();
    }

    private List<Car> createCars(int carCount) {
        IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .forEach(cars::add);
        return cars;
    }

}
