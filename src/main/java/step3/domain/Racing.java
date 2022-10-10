package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars;

    private final int iterate;

    public Racing(String[] carNames, int iterate, MovableStrategy movableStrategy) {
        this.cars = this.createCars(carNames, movableStrategy);
        this.iterate = iterate;
    }

    public Racing(List<Car> cars, int iterate) {
        this.cars = cars;
        this.iterate = iterate;
    }

    public void start() {
        for (int round = 0; round < this.iterate; round++) {
            this.runRound();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinners() {
        Map<String, Integer> lastRecords = this.mapLastRecords(cars);
        Integer winnerLastRecord = this.getWinnerLastRecord(lastRecords);
        return this.filterWinners(winnerLastRecord, lastRecords);
    }

    private void runRound() {
        this.cars.forEach(Car::move);
    }

    private List<Car> createCars(String[] carNames, MovableStrategy movableStrategy) {
        return Arrays.stream(carNames)
                .map((carName) -> new Car(carName, movableStrategy))
                .collect(Collectors.toList());
    }

    private Map<String, Integer> mapLastRecords(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    Record record = car.getRecord();
                    return Map.entry(car.getName(), record.getLastRecord());
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Integer getWinnerLastRecord(Map<String, Integer> lastRecords) {
        return lastRecords.values().stream()
                .mapToInt(integer -> integer)
                .max()
                .orElseThrow(() -> new NoSuchElementException("승자의 기록을 찾기위해서 1개이상의 기록이 필요합니다."));
    }

    private List<String> filterWinners(Integer winnerLastRecord, Map<String, Integer> lastRecords) {
        return lastRecords.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), winnerLastRecord))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
