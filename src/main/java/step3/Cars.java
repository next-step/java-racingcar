package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarsByStrategy() {
        for (Car car : cars) {
            car.move(new RandomMoveStrategy());
        }
    }

    public List<Integer> showCarsDistances() {
        List<Integer> carsDistances = new ArrayList<>();
        for (Car car : cars) {
            carsDistances.add(car.showDistance());
        }
        return carsDistances;
    }
}
