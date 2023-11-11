package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public List<Car> generateCars (String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }

    public List<Car> race() {
        moveCars();
        return cars;
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return getWinners(maxPosition);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.selectMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isCarAtMaxPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(new RandomNumberMoveStrategy());
        }
    }
}
