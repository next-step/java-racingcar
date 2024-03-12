package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int carNumbers, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car(moveStrategy));
        }
    }

    public Cars(int carNumbers, String[] carNames, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car(carNames[i], moveStrategy));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForwardOnChance();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
