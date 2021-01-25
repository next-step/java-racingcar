package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveForward() {
        this.distance++;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public static List<Car> asCarsList(String carNames) {
        String[] names = carNames.split(",");
        List<Car> carsList = new ArrayList<>();
        for (String name : names) {
            carsList.add(new Car(name));
        }
        return carsList;
    }
}
