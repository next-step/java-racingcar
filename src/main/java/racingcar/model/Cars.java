package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private List<Car> cars;
    private NumberGenerator numberGenerator;

    static Cars generate(int count) {
        List<Car> cars = IntStream.range(0, count)
                .mapToObj(value -> new Car()).collect(Collectors.toList());
        return new Cars(cars, new RandomGenerator());
    }

    Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    List<Car> moveAll() {
        for (Car car : cars) {
            car.move(numberGenerator.getNumber());
        }
        return getCars();
    }

    List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" + "cars=" + cars + '}';
    }
}
