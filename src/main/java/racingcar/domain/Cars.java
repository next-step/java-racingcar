package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final int userInput) {
        this.create(userInput);
    }

    private void create(final int userInput) {
        for (int i = 0; i < userInput; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

}