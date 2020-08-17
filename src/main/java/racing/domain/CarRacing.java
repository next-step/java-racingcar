package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private static final int START_LOCATION = 0;

    private int times;
    private Cars cars;
    private List<RaceRecord> raceRecords;
    private MovableRule movableRule;

    public CarRacing(List<String> names, int times, MovableRule movableRule) {
        validateParameter(names.size(), times);

        this.cars = new Cars(names, START_LOCATION);
        this.raceRecords = new ArrayList<>();
        this.times = times;
        this.movableRule = movableRule;
    }

    public void run() {
        for (int i = 1; i <= times; i++) {
            step(i);
        }
    }

    private void step(int raceNumber) {
        cars.racingOneGame(movableRule);

        raceRecords.add(RaceRecord.of(raceNumber, cars));
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

    public List<String> findWinnerNames() {
        return Winners.of(cars).getWinnerNames();
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
