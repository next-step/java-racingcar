package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Ready {
    public List<Car> createCars(String[] playerList) {
        List<Car> cars = new ArrayList<>();
        for (String player : playerList) {
            cars.add(new Car(player));
        }
        return cars;
    }
}
