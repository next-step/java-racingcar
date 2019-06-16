package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = Car.createCar();
            cars.add(car);
        }
    }

    public List<Integer> move() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            int position = car.move();
            positions.add(position);
        }

        return positions;
    }
}
