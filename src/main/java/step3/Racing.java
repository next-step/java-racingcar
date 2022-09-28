package step3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
    private final String[] carNames;

    private final int iterate;

    private final List<Car> cars = new ArrayList<>();

    public Racing(String[] carNames, int iterate) {
        this.carNames = carNames;
        this.iterate = iterate;
        this.createCars();
    }

    public void start() {
        for (int i = 0; i < iterate; i++) {
            this.runRound();
        }
    }

    public List<Car> getRacingRecordOfCars() {
        return this.cars;
    }

    public List<String> getWinners() {
        Map<String, Integer> lastRecords = this.mapLastRecords(cars);
        Integer winnerLastRecord = this.getWinnerLastRecord(lastRecords);
        List<String> winners = this.filterWinners(winnerLastRecord, lastRecords);
        return winners;
    }

    private void createCars() {
        for (String carName : this.carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private void runRound() {
        this.cars.forEach(Car::moveByRandomOnRound);
    }

    private Map<String, Integer> mapLastRecords(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    List<Integer> racingRecord = car.getRacingRecord();
                    System.out.println("racingRecord = " + racingRecord);
                    Integer lastRecord = racingRecord.get(racingRecord.size() - 1);
                    return Map.entry(car.getName(), lastRecord);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Integer getWinnerLastRecord(Map<String, Integer> lastRecords) {
        return lastRecords.entrySet().stream()
                .mapToInt(entry -> entry.getValue())
                .max()
                .orElseThrow(() -> new NoSuchElementException("승자의 기록을 찾기위해서 1개이상의 기록이 필요합니다."));
    }

    private List<String> filterWinners(Integer winnerLastRecord, Map<String, Integer> lastRecords) {
        return lastRecords.entrySet().stream()
                .filter(entry -> entry.getValue() == winnerLastRecord)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
