package retry.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean contains(Car test) {
        return this.cars.contains(test);
    }

    public Cars moveCarsPositionByInterface(Movable movable) {
        List<Car> carsWithPosition = new ArrayList<>();
        for (Car car : this.cars) {
            carsWithPosition.add(car.move(movable.isMove()));
        }
        return new Cars(carsWithPosition);
    }

}
