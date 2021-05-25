package racingCar2;

import java.util.ArrayList;
import java.util.List;

public class Ready {

    private static final String SPLIT_VALUE = ",";

    public String[] createPlayerList(String name) {
        return name.split(SPLIT_VALUE);
    }

    public List<Car> createCars(String[] playerList) {
        List<Car> cars = new ArrayList<>();
        for (String s : playerList) {
            cars.add(new Car(s));
        }
        return cars;
    }
}
