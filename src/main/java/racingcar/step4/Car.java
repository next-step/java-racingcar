package racingcar.step4;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static List<Car> createCar(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name,0));
        }

        return carList;
    }

    public void setDistance() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
