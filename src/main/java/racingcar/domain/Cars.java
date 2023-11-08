package racingcar.domain;

import racingcar.service.ValidationCheck;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(String input) {
        this.cars = new ArrayList<>();
        addCar(input);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    private void addCar(String input) {
        String[] names = input.split(",");

        for (int i = 0; i < names.length; i++) {
            ValidationCheck.checkInputCarName(names[i]);
            cars.add(new Car(names[i]));
        }
    }
}