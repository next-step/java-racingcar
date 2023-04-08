package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    private List<Car> cars;

    public Factory(int userInput) {
        cars = createCars(userInput);
    }

    public List<Car> createCars(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
