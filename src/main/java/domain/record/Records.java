package domain.record;

import domain.car.Car;
import domain.car.Cars;
import vo.CarRecord;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class Records {

    private final List<CarRecord> gameRecord = new ArrayList<>();

    public void add(Cars cars) {
        for (Car car : cars.cars()) {
            gameRecord.add(new CarRecord(car.name(), car.distance()));
        }
    }

    public List<CarRecord> winners() {
        List<CarRecord> recordList = removeDuplicateRecord();
        int maxDistance = maxDistance(recordList);

        return findWinners(recordList, maxDistance);
    }

    private List<CarRecord> removeDuplicateRecord() {
        return gameRecord.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private int maxDistance(List<CarRecord> records) {
        return records.stream()
                .max(comparingInt(CarRecord::distance))
                .get()
                .distance();
    }

    private List<CarRecord> findWinners(List<CarRecord> recordList, int maxDistance) {
        return recordList.stream()
                .filter(record -> record.distance() == maxDistance)
                .collect(Collectors.toList());
    }

    public List<CarRecord> gameRecord() {
        return gameRecord;
    }
}
