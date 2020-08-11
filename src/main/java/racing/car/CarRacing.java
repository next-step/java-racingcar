package racing.car;

import racing.car.model.Car;
import racing.car.model.RaceRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private List<Car> cars;
    private int times;
    private List<RaceRecord> raceRecords;
    private MovableRule movableRule;

    public CarRacing(String[] names, int times, MovableRule movableRule) {
        validateParameter(names.length, times);

        this.cars = new ArrayList<>();
        this.raceRecords = new ArrayList<>();
        this.times = times;
        this.movableRule = movableRule;

        for (String name : names) {
            cars.add(new Car(name, 0));
        }
    }

    public void run() {
        for (int i = 1; i <= times; i++) {
            step(i);
        }
    }

    private void step(int raceNumber) {
        for (Car car : cars) {
            racing(car);
        }

        raceRecords.add(RaceRecord.of(raceNumber, cars));
    }

    private void racing(Car car) {
        if (movableRule.isMovable()) {
            car.go();
        }
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

    private void validateParameter(int carNumber, int times) {
        if (carNumber <= 0) {
            throw new IllegalArgumentException("경주 자동차는 한대 이상이어야 합니다");
        }

        if (times <= 0) {
            throw new IllegalArgumentException("경기 횟수는 1회 이상이어야 합니다.");
        }
    }

    public List<String> findWinner() {
        Comparator<Car> carComparator = Comparator.comparing(Car::getLocation);
        int longestDistance = Collections.max(cars, carComparator).getLocation();

        return cars.stream()
                .filter(car -> car.getLocation() == longestDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
