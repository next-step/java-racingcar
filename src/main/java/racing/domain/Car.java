package racing.domain;

import racing.behavior.CarMovable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private static final int INITIAL_LOCATION = 0;

    private int location;
    private final CarMovable movable;

    public Car(final int location, final CarMovable movable) {
        this.location = location;
        this.movable = movable;
    }

    public static Car of(final CarMovable movable) {
        return new Car(INITIAL_LOCATION, movable);
    }

    public static List<Car> listOf(final int number, final CarMovable movable) {
        final List<Car> cars = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            cars.add(of(movable));
        }
        return cars;
    }

    public static List<Car> raceOfCars(final List<Car> cars) {
        return cars.stream()
                .peek(Car::move)
                .collect(Collectors.toList());
    }

    public void move() {
        if (movable.move()) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
