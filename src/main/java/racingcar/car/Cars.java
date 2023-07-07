package racingcar.car;

import racingcar.util.MathUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<CarName> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<String> getWinnerNames() {
        Position winnerPosition = getMaxPosition();
        return cars.stream()
                .filter(c -> c.isWinner(winnerPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = MathUtil.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<CarResponse> getCars() {
        return cars.stream()
                .map(CarResponse::of)
                .collect(Collectors.toList());
    }
}
