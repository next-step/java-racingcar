package racing.car;

import racing.car.model.Car;
import racing.car.model.RaceRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private List<Car> cars;
    private int times;
    private List<RaceRecord> raceRecords;
    private MovableRule movableRule;

    public CarRacing(int carNumber, int times, MovableRule movableRule) {
        validateParameter(carNumber, times);

        this.cars = new ArrayList<>();
        this.raceRecords = new ArrayList<>();
        this.times = times;
        this.movableRule = movableRule;

        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(i, 0));
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

        raceRecords.add(new RaceRecord(raceNumber, makeTrackRecords()));
    }

    private void racing(Car car) {
        if (movableRule.isMovable()) {
            car.go();
        }
    }

    private List<Integer> makeTrackRecords() {
        return cars.stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
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

}
