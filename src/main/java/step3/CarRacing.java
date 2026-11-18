package step3;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class CarRacing {

    private final List<Car> cars;
    private int tryCount;
    private final MoveStrategy strategy;

    public CarRacing(int carCount, int tryCount, MoveStrategy strategy) {
        if (carCount < 2 || carCount > 10) {
            throw new RuntimeException("자동차 대수는 2 이상 10 이하의 숫자만 입력 가능합니다.");
        }

        if (tryCount < 1 || tryCount > 10) {
            throw new RuntimeException("시도할 횟수는 1 이상 10 이하의 숫자만 입력 가능합니다.");
        }

        this.cars = IntStream.range(0, carCount)
            .mapToObj(i -> new Car(i + 1))
            .toList();
        this.tryCount = tryCount;
        this.strategy = Objects.requireNonNull(strategy, "이동 전략은 null일 수 없습니다.");
    }

    public List<Car> currentCars() {
        return cars;
    }

    public List<Car> racingCars() {
        if (tryCount-- < 1) {
            throw new RuntimeException();
        }

        return cars.stream()
            .map(this::moveCar)
            .toList();
    }

    public int getTryCount() {
        return tryCount;
    }

    private Car moveCar(Car car) {
        if (strategy.isMovable()) {
            car.move();
            return car;
        }

        return car;
    }
}
