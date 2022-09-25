package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(String carNameText) {
        this.cars = new ArrayList<>();
        cars = createRacingCars(carNameText);
    }

    protected List<Car> createRacingCars(String carNameText) {
        return Arrays.stream(carNameText.split(",")).map(Car::new).collect(Collectors.toList());
    }

    public void race() {
        this.cars.forEach(Car::run);
    }

    public List<Car> showCars() {
        return this.cars;
    }

}
