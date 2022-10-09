package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.NumberGenerateStrategy;

public class Racers {

    private final List<Car> cars = new ArrayList<>();
    private NumberGenerateStrategy numberGenerateStrategy;

    private Racers() {
    }

    public Racers(final List<String> carNames, final NumberGenerateStrategy numberGenerateStrategy) {
        carNames.forEach(name -> {
            this.cars.add(new Car(name));
        });

        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveAll() {
        this.cars.forEach(car -> {
            car.move(numberGenerateStrategy.generate());
        });
    }

    public List<Integer> positions() {
        return cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }

    public int maxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("최대 값을 찾는데 실패했습니다."));
    }
}
