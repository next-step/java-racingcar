package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.strategy.NumberGenerateStrategy;

public class Racing {

    private Cars cars;
    private final List<List<Integer>> result = new ArrayList<>();

    private Racing() {}

    public Racing(List<String> carNames, NumberGenerateStrategy strategy) {
        this.cars = new Cars(carNames, strategy);
    }

    public List<List<Integer>> result() {
        return this.result;
    }

    public void race(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            cars.moveAll();
            result.add(cars.allPosition());
        }
    }

    public List<String> winners() {
        int maxPosition = cars.maxPosition();
        return cars.carList().stream()
            .filter(car -> car.position() == maxPosition)
            .map(Car::name)
            .collect(Collectors.toList());
    }
}
