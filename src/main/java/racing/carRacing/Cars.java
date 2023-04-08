package racing.carRacing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(Count numberOfCars) {
        cars = numberOfCars.initCars(cars);
    }

    public void run() {
        cars.forEach(car -> car.run(new RandomMovement()));
    }
}
