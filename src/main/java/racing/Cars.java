package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int participationCars, List<Integer> oldPositions) {
        createCars(participationCars, oldPositions);
    }

    private void createCars(int participationCars, List<Integer> oldPositions) {
        for (int i = 0; i < participationCars; i++) {
            cars.add(new Car(oldPositions.get(i)));
        }
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public void go() {
        for (Car car : cars) {
            car.move(new MoveStrategyImpl());
        }
    }

    public int size() {
        return cars.size();
    }
}
