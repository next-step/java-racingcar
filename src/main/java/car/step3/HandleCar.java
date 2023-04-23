package car.step3;

import java.util.List;
import java.util.Random;

import static car.step3.Main.MAX_LOCATION;

public class HandleCar {

    public List<Car> iteratorCar(List<Car> cars) {
        for (Car car : cars) {
            goCar(car);
        }
        return cars;
    }

    public void goCar(Car car) {
        car.go();
    }
}
