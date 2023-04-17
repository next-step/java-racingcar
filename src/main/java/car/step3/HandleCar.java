package car.step3;

import java.util.List;
import java.util.Random;

import static car.step3.Main.MAX_LOCATION;

public class HandleCar {
    Random random = new Random();

    public List<Car> iteratorCar(List<Car> cars) {
        for (Car car : cars) {
            goCar(car);
        }
        return cars;
    }

    public void goCar(Car car) {
        if(random.nextInt(10) >= 4) {
            car.go();
        }
        maxLocation(car);
    }

    public void maxLocation(Car car) {
        if(car.location() > MAX_LOCATION) {
            MAX_LOCATION = car.location();
        }
    }
}
