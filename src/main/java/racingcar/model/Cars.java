package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private NumberGenerator numberGenerator;
    private List<Car> cars;

    Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    static Cars generate(int count) {
        if(count < 0){
            throw new IllegalArgumentException("자동차 개수는 정수여야 합니다.");
        }
        List<Car> cars = IntStream.range(0, count)
                .mapToObj(value -> Car.create())
                .collect(Collectors.toList());
        return new Cars(cars, new RandomGenerator());
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
