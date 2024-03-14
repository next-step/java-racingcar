package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final String DELIMITER_COMMA = ",";
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void initCars(String inputName) {
        String[] names = splitCarName(inputName);
        for (String name : names) {
            addCar(name);
        }
    }

    private String[] splitCarName(String inputName) {
        return inputName.split(DELIMITER_COMMA);
    }

    private void addCar(String inputName) {
        cars.add(new Car(inputName));
    }

    public Position maxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .map(Car::getPosition)
                .orElse(null);
    }

    public List<Car> getCars() {
        return cars;
    }
}
