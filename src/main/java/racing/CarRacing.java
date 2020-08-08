package racing;

import racing.model.Car;
import racing.model.RaceRecord;
import racing.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private List<Car> cars;
    private int times;
    private List<RaceRecord> raceRecords;

    public static final int RANDOM_BOUND = 10;
    public static final int RANDOM_STANDARD = 4;

    public CarRacing(int carNumber, int times) {
        this.cars = new ArrayList<>();
        this.raceRecords = new ArrayList<>();
        this.times = times;

        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(i, 0));
        }
    }

    public void start() {
        for (int i = 0; i < times; i++) {
            step(i);
        }
    }

    private void step(int raceNumber) {
        for (Car car : cars) {
            car.go(isMovable());
        }

        raceRecords.add(new RaceRecord(raceNumber, makeRaceTrace()));
    }

    private boolean isMovable(){
        return RandomUtil.randomInt(RANDOM_BOUND) >= RANDOM_STANDARD;
    }

    private List<Integer> makeRaceTrace() {
        return cars.stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

}
