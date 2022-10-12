package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.NumberGenerateStrategy;

public class Racers {

    private List<Car> cars;

    private Racers() {
    }

    public Racers(final List<String> carNames) {
        this.cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveAll(final NumberGenerateStrategy strategy) {
        this.cars.forEach(car -> {
            car.move(strategy);
        });
    }

    public List<Integer> getPositions() {
        return cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("최대 값을 찾는데 실패했습니다."));
    }

    public List<Car> findSamePositionCars(int position) {
        return cars.stream()
            .filter(car -> car.getPosition() == position)
            .collect(Collectors.toList());
    }
}
