package step3.Model;

import java.util.ArrayList;
import java.util.List;

public class CarsManager {

    private List<Car> cars;

    public CarsManager(List<Car> cars) {
        this.cars = cars;
    }

    public static CarsManager withCarCount(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return new CarsManager(cars);
    }

    public void tryMoveCars(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.move(movableStrategy);
        }
    }

    public List<Integer> getCarsPosition() {
        List list = new ArrayList<Integer>();

        for (Car car : cars) {
            list.add(car.getPosition());
        }

        return list;
    }
}
