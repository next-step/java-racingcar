package record;

import car.Car;
import car.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class Records {

    private final List<CarRecord> gameRecord = new ArrayList<>();
    private final List<CarRecord> winners = new ArrayList<>();

    public void add(Cars cars) {
        for (Car car : cars.cars()) {
            gameRecord.add(new CarRecord(car.name(), car.distance()));
        }
    }

    public void addWinners() {
        List<CarRecord> recordList = removeDuplicateRecord();
        int maxDistance = maxDistance(recordList);

        for (CarRecord car : recordList) {
            findWinner(car, maxDistance);
        }
    }

    private List<CarRecord> removeDuplicateRecord() {
        return gameRecord.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private int maxDistance(List<CarRecord> records) {
        int maxDistance = 0;

        for (CarRecord car : records) {
            maxDistance = Math.max(maxDistance, car.distance());
        }

        return maxDistance;
    }

    private void findWinner(CarRecord car, int maxDistance) {
        if (car.distance() == maxDistance) {
            winners.add(car);
        }
    }

    public List<CarRecord> gameRecord() {
        return gameRecord;
    }

    public List<CarRecord> winners() {
        return winners;
    }

}
