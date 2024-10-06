package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private static final String DELIMITER = ",";
    private final List<Car> cars;

    private Garage(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("차는 최소 1대 이상 필요 합니다.");
        }

        this.cars = new ArrayList<>(cars);
    }

    public static Garage createCars(String names) {

        ArrayList<Car> cars = new ArrayList<>();

        String[] drivers = names.split(DELIMITER);

        for (String driver : drivers) {
            cars.add(new Car(driver));
        }

        return new Garage(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
