package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] names, List<Integer> oldPositions) {
        createCars(names, oldPositions);
    }

    private void createCars(String[] names, List<Integer> oldPositions) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(oldPositions.get(i), names[i]));
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
