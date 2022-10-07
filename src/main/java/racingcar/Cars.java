package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.NumberGenerateStrategy;

public class Cars {

    private final List<Car> carList = new ArrayList<>();
    private NumberGenerateStrategy numberGenerateStrategy;

    private Cars() {
    }

    public Cars(int number, NumberGenerateStrategy numberGenerateStrategy) {
        for (int i = 0; i < number; i++) {
            this.carList.add(new Car());
        }
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public void moveAll() {
        this.carList.forEach(car -> {
            car.move(numberGenerateStrategy.generate());
        });
    }

    public List<Integer> allPosition() {
        return carList.stream()
            .map(Car::position)
            .collect(Collectors.toList());
    }
}
