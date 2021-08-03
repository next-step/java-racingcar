package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RaceResult {
    private int roundCount;
    private List<MovingRecord> movingRecords;

    public RaceResult(int roundCount, List<Car> cars) {
        this.roundCount = roundCount;
        movingRecords = initMovingRecords(cars);
    }

    private List<MovingRecord> initMovingRecords(List<Car> cars) {
        return cars.stream().map(car -> new MovingRecord(car.getName())).collect(Collectors.toList());
    }

    public void report(List<Car> cars) {
        for (Car car : cars) {
            MovingRecord movingRecord = findMovingRecord(car.getName());
            movingRecord.addPositionRecord(car.getPosition());
        }
    }

    private MovingRecord findMovingRecord(Name name) {
        MovingRecord findMovingRecord = movingRecords.stream()
                .filter(movingRecord -> movingRecord.isSame(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 차 이름입니다."));
        return findMovingRecord;
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        return movingRecords.stream()
                .filter(movingRecord -> movingRecord.isLastPositionSame(maxPosition))
                .map(MovingRecord::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return movingRecords.stream()
                .max(Comparator.comparingInt(movingRecord -> movingRecord.getLastPosition()))
                .orElseThrow(() -> new NoSuchElementException("값이 없습니다."))
                .getLastPosition();
    }


    public int getRoundCount() {
        return roundCount;
    }

    public List<MovingRecord> getMovingRecords() {
        return movingRecords;
    }
}
