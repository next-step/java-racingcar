package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRecord {
    private final String name;
    private final int distance;

    public CarRecord(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarRecord from(Car car) {
        return new CarRecord(car.getName(), car.getDistance());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
