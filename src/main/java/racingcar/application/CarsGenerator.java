package racingcar.application;

import racingcar.domain.Car;

public class CarsGenerator {
    public Car[] generateCars(String[] nameOfCars) {
        Car[] cars = new Car[nameOfCars.length];
        for (int i = 0; i < nameOfCars.length; i++) {
            String name = nameOfCars[i];
            validateName(name);
            cars[i] = new Car(name, 0);
        }
        return cars;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("the name must be less than five characters.");
        }
    }
}
