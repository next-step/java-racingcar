package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(String carNameText) {
        cars = new ArrayList<>();
        Arrays.stream(carNameText.split(",")).forEach(name -> cars.add(new Car(name)));
    }

    public List<Car> race() {
        cars.forEach(Car::run);
        return cars;
    }

}
