package racingcar.step4;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private int distance;
    private static final int MIN_NUMBER = 4;

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static List<Car> createCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name, 0));
        }

        return carList;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_NUMBER) {
            distance++;
        }

    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
