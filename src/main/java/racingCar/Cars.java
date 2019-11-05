package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int numbersOfCar) {
        this.cars = new ArrayList<>();
        createCars(numbersOfCar);
    }

    private void createCars(int numbersOfCar) {
        for (int i = 0; i < numbersOfCar; i++) {
            this.cars.add(new Car());
        }
    }

    public Integer[] move() {
        Integer[] time = new Integer[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move();
            time[i] = car.getPosition();
        }
        return time;
    }
}
