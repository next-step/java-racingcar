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

    public Positions getPositions() {
        List<Position> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getPosition());
        }
        return new Positions(result);
    }
}
