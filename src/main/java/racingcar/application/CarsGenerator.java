package racingcar.application;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsGenerator {

    public List<Car> generateCars(String nameOfCars) {
        List<Car> cars = new ArrayList<>();
        List<String> names = getNamesOfCar(nameOfCars);

        for (String nameOfCar : names) {
            validateName(nameOfCar);
            Car car = new Car(nameOfCar, 0);
            cars.add(car);
        }

        return cars;
    }

    private List<String> getNamesOfCar(String nameOfCars) {
        String[] names = nameOfCars.split(",");
        return Arrays.asList(names);
    }

    private void validateName(String name) {
        Integer MAXIMUM_LENGTH_NAME_OF_CAR = 5;
        Integer MINIMUM_NUMBER_OF_CARS = 0;
        String BLANK_NAME = "";
        String BLANK = " ";

        if (name.equals(BLANK_NAME) || name.equals(BLANK)) {
            throw new IllegalArgumentException("the name must not blank.");
        }
        if (name.length() <= MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("the name must be more than zero characters.");
        }
        if (name.length() >= MAXIMUM_LENGTH_NAME_OF_CAR) {
            throw new IllegalArgumentException("the name must be less than five characters.");
        }
    }
}

