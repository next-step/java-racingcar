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

    public Cars(List<String> carNames, NumberGenerateStrategy numberGenerateStrategy) {
        carNames.forEach(name -> {
            this.carList.add(new Car(name));
        });

        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public List<Car> carList() {
        return this.carList;
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
