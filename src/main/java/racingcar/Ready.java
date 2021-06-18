package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Ready {
    private static final String SPLIT_VALUE = ",";

    public List<Car> createCars(String name) {
        return createCars(splitName(name));
    }

    private String[] splitName(String name) {
        return name.split(SPLIT_VALUE);
    }

    public List<Car> createCars(String[] playerList) {
        List<Car> cars = new ArrayList<>();
        for (String player : playerList) {
            cars.add(new Car(player));
        }
        return cars;
    }
}
