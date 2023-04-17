package race;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int numOfCars, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            cars.add(new Car(moveStrategy));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
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
