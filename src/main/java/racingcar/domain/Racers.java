package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.MovingStrategy;

public class Racers {

    private List<Car> cars;

    public Racers(final List<String> carNames) {
        validateCarNames(carNames);
        this.cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void validateCarNames(final List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 누락되었습니다.");
        }
    }

    public void moveAll(final MovingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("MovingStrategy 객체가 누락되었습니다.");
        }

        this.cars.forEach(car -> {
            car.move(strategy);
        });
    }

    public List<Car> findSamePositionCars(final int position) {
        return cars.stream()
            .filter(car -> car.isSamePosition(position))
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
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
}
