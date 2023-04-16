package domain.record;

import domain.car.Car;
import domain.car.Cars;
import vo.CarRecord;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Records {

    private final List<CarRecord> gameRecord = new ArrayList<>();
    private final int countOfCars;

    public Records(String... nameOfCars) {
        this.countOfCars = nameOfCars.length;
    }

    public void add(Cars cars) {
        for (Car car : cars.cars()) {
            gameRecord.add(new CarRecord(car.name(), car.distance()));
        }
    }

    public List<CarRecord> winners() {
        List<CarRecord> gameResult = finalRoundRecords();
        CarRecord winnerRecord = Collections.max(gameResult);

        return findWinners(gameResult, winnerRecord);
    }

    private List<CarRecord> finalRoundRecords() {
        int start = gameRecord.size() - 1;
        int end = gameRecord.size() - 1 - countOfCars;

        return IntStream.iterate(start, i -> i > end, i -> i - 1)
                .mapToObj(gameRecord::get)
                .collect(Collectors.toList());
    }

    private List<CarRecord> findWinners(List<CarRecord> gameResult, CarRecord winnerRecord) {
        return gameResult.stream()
                .filter(record -> record.distance() == winnerRecord.distance())
                .collect(Collectors.toList());
    }

    public List<CarRecord> gameRecord() {
        return gameRecord;
    }
}
