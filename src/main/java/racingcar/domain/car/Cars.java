package racingcar.domain.car;

import racingcar.domain.car.strategy.CarActionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (isNullOrEmpty(cars)) {
            throw new IllegalArgumentException("빈 컬렉션은 Cars를 생성 할 수 없다.");
        }
    }

    private boolean isNullOrEmpty(List<Car> cars) {
        return cars == null || cars.isEmpty();
    }

    public Cars(int carCount, CarActionStrategy carActionStrategy) {
        validateCarCountsAndStrategy(carCount, carActionStrategy);
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(carActionStrategy));
        }
    }

    private void validateCarCountsAndStrategy(int carCount, CarActionStrategy carActionStrategy) {
        if (carCount < 1) {
            throw new IllegalArgumentException("Cars는 최소 1대 이상이어야 합니다.");
        }

        if (carActionStrategy == null) {
            throw new IllegalArgumentException("carActionStrategy는 null일 수 없습니다.");
        }
    }

    public Cars act() {
        return new Cars(cars.stream().map(Car::act).collect(Collectors.toList()));
    }

    public List<Integer> getCarPositions() {
        return cars.stream().map(Car::getPosition).collect(Collectors.toList());
    }
}
