package racingcar.model;

import racingcar.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private static final int INIT_CAR_DISTANCE = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        List<Car> cars = new ArrayList<>(names.size());

        for (String name : names) {
            cars.add(new Car(name, INIT_CAR_DISTANCE));
        }

        return new Cars(cars);
    }

    public void moveCars(MoveStrategy strategy) {
        this.cars.forEach(car -> car.move(strategy));
    }

    public List<Car> getWinnerCars() {
        int maxDistance = getMaxDistance();
        return this.cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return this.cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("값이 없습니다."));
    }

    public List<Car> getCars() {
        return cars;
    }

}
