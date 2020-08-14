package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
