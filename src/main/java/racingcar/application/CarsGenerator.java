package racingcar.application;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsGenerator {

    Integer maximumLengthNameOfCar = 5;
    Integer minimumNumberOfCars = 0;
    String blankName = "";
    String blank = " ";

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

        if (name.equals(blankName) || name.equals(blank)) {
            throw new IllegalArgumentException("the name must not blank.");
        }
        if (name.length() <= minimumNumberOfCars) {
            throw new IllegalArgumentException("the name must be more than zero characters.");
        }
        if (name.length() >= maximumLengthNameOfCar) {
            throw new IllegalArgumentException("the name must be less than five characters.");
        }
    }
}

