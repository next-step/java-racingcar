package step4.model;

import step4.util.Error;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final int VALID_CARS_SIZE = 3;
    private static final String SPLIT_REGEX = ",";
    private static final String EMPTY = "";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        validate(names);
        split(names);
    }

    public void split(String names) {
        String[] list = names.split(SPLIT_REGEX);
        addCars(list);
    }

    private void addCars(String[] list) {
        validateCarsSize(list);
        for(String name: list) {
            cars.add(Car.of(name));
        }
    }

    private void validateCarsSize(String[] list) {
        if (list.length != VALID_CARS_SIZE) {
            throw new IllegalArgumentException(Error.INVALID_SIZE);
        }
    }

    public Result move(Fuel fuel) {
        List<Car> list = moveCars(fuel);
        return new Result(list);
    }

    private List<Car> moveCars(Fuel fuel) {
        cars.forEach(car -> car.move(fuel));
        return cars;
    }

    private void validate(String names) {
        if(names == null) {
            throw new IllegalArgumentException(Error.NULL);
        }
        if(names == EMPTY) {
            throw new IllegalArgumentException(Error.EMPTY);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }


}