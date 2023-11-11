package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

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
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<Car> Winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                Winners.add(car);
            }
        }
        return Winners;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(new RandomNumberMoveStrategy());
        }
    }
}
