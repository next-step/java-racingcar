package racing.carRacing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars initCars(Count numberOfCar) {
        List<Car> cars = new ArrayList<>();
        while (numberOfCar.isOverZero()) {
            numberOfCar.countDown();
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public void run() {
        cars.forEach(car -> car.run(new RandomMovementStrategy()));
    }

    public Car getCurrentCar(int index) {
        return cars.get(index);
    }

    public int getCarsSize() {
        return cars.size();
    }

}
