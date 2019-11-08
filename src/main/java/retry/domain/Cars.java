package retry.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int PIVOT_NUMBER = 4;
    private static final int RANDOM_BOUND_NUMBER = 9;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean contains(Car test) {
        return this.cars.contains(test);
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND_NUMBER);
    }

    public List<Car> moveCarsPositionByInterface(Movable movable) {
        List<Car> carsWithPosition = new ArrayList<>();
        for (Car car : this.cars) {
            carsWithPosition.add(car.move(movable.isMove()));
        }
        return carsWithPosition;
    }

}
