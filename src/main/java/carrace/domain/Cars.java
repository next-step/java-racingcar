package carrace.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private static final int ZERO = 0;
    private final List<Car> cars;

    public Cars(List<String> players) {
        this.cars = IntStream.range(ZERO, players.size())
                .mapToObj(index -> new Car(players.get(index)))
                .collect(Collectors.toList());
    }

    Cars(Car... cars) {
        this.cars = new ArrayList<>(Arrays.asList(cars));
    }

    private Cars(Cars cars) {
        this.cars = cars.getCopy();
    }

    public void move(Movable movable) {
        for (Car car : cars) {
            car.move(movable.isMovable());
        }
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public int getNumberOfCar() {
        return cars.size();
    }

    public int getPosition(int index) {
        return cars.get(index).getPosition();
    }

    public String getCarName(int index) {
        return cars.get(index).getName();
    }

    public List<Car> getCopy() {
        return cars.stream()
                .map(Car::copy)
                .collect(Collectors.toList());
    }

    public Cars copy() {
        return new Cars(this);
    }
}
