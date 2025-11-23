package model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String carNameInput) {
        cars = new ArrayList<>();

        String[] carNames = parseCarNames(carNameInput);
        for (String carName : carNames) {
            cars.add(new Car(1, carName));
        }
    }

    private String[] parseCarNames(String carNameInput) {
        return carNameInput.split(",");
    }

    public int getCarsCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
