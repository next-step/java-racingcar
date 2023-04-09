package racing.carRacing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(Count numberOfCars) {
        cars = initCars(numberOfCars);
    }

    private List<Car> initCars(Count numberOfCar) {
        cars = new ArrayList<>();
        while (numberOfCar.isOverZero()) {
            numberOfCar.countDown();
            cars.add(new Car());
        }
        return cars;
    }

    public void run() {
        cars.forEach(car -> car.run(new RandomMovement()));
    }

    public Car getCurrentCar(int index) {
        return cars.get(index);
    }

    public int getCarsSize() {
        return cars.size();
    }

}
