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
        validateParameter(carNumber, times);

        this.cars = new ArrayList<>();
        this.raceRecords = new ArrayList<>();
        this.times = times;

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
            car.go(isMovable());
        }

        raceRecords.add(new RaceRecord(raceNumber, makeTrackRecords()));
    }

    private boolean isMovable(){
        return RandomUtil.randomInt(RANDOM_BOUND) >= RANDOM_STANDARD;
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
