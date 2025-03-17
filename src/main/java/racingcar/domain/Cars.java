package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private List<Car> winnerCars;

    private Cars(List<Car> cars) {
        this.cars = cars;
        this.winnerCars = null;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public String getWinnerCarNames() {
        return getWinnerCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private List<Car> getWinnerCars() {
        if (this.winnerCars != null) {
            return this.winnerCars;
        }
        Car maxCar = getCarWithMaxPosition(this.cars);
        this.winnerCars = this.cars.stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .collect(Collectors.toList());
        return this.winnerCars;
    }

    private Car getCarWithMaxPosition(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalStateException::new);
    }

    public String getRaceStatusString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getStatusString()).append('\n');
        }
        return stringBuilder.toString();
    }

    public void moveAll(MoveStrategy moveStrategy) {
        if (winnerCars != null) {
            throw new IllegalStateException("우승자가 이미 결정되었습니다.");
        }
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }
}
