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
    private void moveCars() {
        for (Car car : cars) {
            car.move(new RandomNumberMoveStrategy());
        }
    }
}
