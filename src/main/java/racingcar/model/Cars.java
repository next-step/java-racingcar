package racingcar.model;

import racingcar.util.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    static Cars generate(int count) {
        if(count < 0){
            throw new IllegalArgumentException("자동차 개수는 정수여야 합니다.");
        }
        List<Car> cars = IntStream.range(0, count)
                .mapToObj(value -> Car.create())
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    Cars moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.getNumber());
        }
        return this;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" + "cars=" + cars + '}';
    }
}
