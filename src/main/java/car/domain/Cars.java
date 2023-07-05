package car.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(CarNames carNames) {
        cars = Arrays.stream(carNames.getCarNames()).map(Car::new).collect(Collectors.toList());
    }

    public void race(Movable movable) {
        for (int i = 0 ; i< this.cars.size() ; i++) {
            Movable carMovable = movable;
            if (carMovable.getMovable()) cars.get(i).move(carMovable.getMovingSize());
        }
    }
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
