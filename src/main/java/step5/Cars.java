package step5;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, new RandomMoveStrategy()));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }
}
