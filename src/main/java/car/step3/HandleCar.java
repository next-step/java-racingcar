package car.step3;

import java.util.List;
import java.util.Random;

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
    }
}
