package racingcar.domain;

import java.util.ArrayList;

public class CarDomain {
    private final String name;
    private int distance;

    public CarDomain(String name) {
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

    public static ArrayList<CarDomain> asCarsList(String carNames) {
        String[] names = carNames.split(",");
        ArrayList<CarDomain> carsList = new ArrayList<>();
        for (String name : names) {
            carsList.add(new CarDomain(name));
        }
        return carsList;
    }
}
