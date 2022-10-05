package domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars;

    public Racing(List<CarName> carNames) { makeCar(carNames); }

    private void makeCar(List<CarName> carNames) {
        this.cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void race(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy.isMovable(movingStrategy.getIntValue()));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
