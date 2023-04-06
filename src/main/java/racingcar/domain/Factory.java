package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    private List<Car> cars;

    public Factory(String userInput) {
        cars = createCars(Integer.parseInt(userInput));
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
