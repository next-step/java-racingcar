package car.step3;

import java.util.List;
import java.util.Random;

public class HandleCar {
    public List<Car> iteratorCar(List<Car> carList) {

        for (Car car : carList) {
            car = isOverFour(car);
        }
        return carList;
    }

    public Car isOverFour(Car car) {
        Random random = new Random();
        if(random.nextInt(10) >= 4) {
            car.go();
        }
        return car;
    }
}
