package racingcar.step5.domain;

import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance;

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

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }


    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Car car) {
        return car.getDistance() - distance;
    }
}
