package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carName) {
        makeCars(carName);
    }

    public List<Car> carList() {
        return cars;
    }

    public void makeCars(List<String> carName) {
        cars = carName.stream().map(Car::new).collect(Collectors.toList());
    }

    public void moveCars(int randomValue) {
        cars.forEach(car -> {
            car.move(randomValue);
        });
    }
}
