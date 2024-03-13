package step3.Model;

import java.util.ArrayList;
import java.util.List;

public class CarsManager {

    private List<Car> cars = new ArrayList();

    public CarsManager(int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    }

    public CarsManager(List<Car> cars) {
        this.cars = cars;
    }

    public void tryMoveCars(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.move(movableStrategy);
        }
    }

    public List getCarsPosition() {
        List list = new ArrayList<Integer>();

        for (Car car : cars) {
            list.add(car.getPosition());
        }

        return list;
    }
}
