package step3.model;

import step3.common.RandomUtil;

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

    public void tryMoveCars() {
        for (Car car : cars) {
            tryMoveCar(car);
        }
    }

    public List getCarsPosition() {
        List list = new ArrayList<Integer>();

        for (Car car : cars) {
            list.add(car.getPosition());
        }

        return list;
    }

    private static void tryMoveCar(Car car) {
        car.move(RandomUtil.makeRandomNumber());
    }


}
