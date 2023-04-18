package race;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<CarName> carNameList, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();
        for (CarName carName : carNameList) {
            cars.add(new Car(carName, moveStrategy));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public void orderMove(String carName) {
        cars.stream()
                .filter(it -> it.getCarName().equals(carName))
                .forEach(Car::moveForward);
    }

    public List<Car> getCarList() {
        return List.copyOf(cars);
    }
}
