package racingcar.domain;

import racingcar.util.MathUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private static final int RANDOM_BOUND = 10;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(Random random) {
        cars.forEach(c -> {
            int power = random.nextInt(RANDOM_BOUND);
            c.move(power);
        });
    }

    public CarNames getWinnerNames() {
        Position winnerPosition = getMaxPosition();
        return new CarNames(cars.stream()
                .filter(c -> c.isWinner(winnerPosition))
                .map(Car::getName)
                .collect(Collectors.toList()));
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
