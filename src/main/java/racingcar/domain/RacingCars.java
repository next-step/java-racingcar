package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(String carNameText) {
        this.cars = new ArrayList<>();
        Arrays.stream(carNameText.split(",")).forEach(name -> this.cars.add(new Car(name)));
    }

    public void race() {
        this.cars.forEach(Car::run);
    }

    public List<Car> showCars(){
        return this.cars;
    }

}
