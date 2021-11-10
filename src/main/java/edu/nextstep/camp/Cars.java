package edu.nextstep.camp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Cars implements Iterable<Car> {
    private static final int MINIMUM_NUMBER_OF_CAR = 1;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static Cars of(String[] names, MovePolicy movePolicy) {
        if (names == null) {
            throw new IllegalArgumentException("Name of cars cannot be null.");
        }

        if (names.length < MINIMUM_NUMBER_OF_CAR) {
            throw new IllegalArgumentException("invalid number of cars: " + names.length);
        }

        List<Car> cars = new ArrayList<>(names.length);
        for (String name : names) {
            cars.add(Car.of(name, movePolicy));
        }

        return new Cars(cars);
    }

    public static Cars of(Car... cars) {
        if (cars == null) {
            throw new IllegalArgumentException("Name of cars cannot be null.");
        }

        if (cars.length < MINIMUM_NUMBER_OF_CAR) {
            throw new IllegalArgumentException("invalid number of cars: " + cars.length);
        }

        return new Cars(Arrays.asList(cars));
    }

    public static Cars of(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("invalid list of cars: " + cars);
        }

        return new Cars(cars);
    }

    public List<Car> list() {
        return cars;
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public int size() {
        return cars.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
