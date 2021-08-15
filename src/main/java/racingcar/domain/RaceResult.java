package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RaceResult {
    private RoundCount roundCount;
    private List<MovingRecord> movingRecords;

    public RaceResult(RoundCount roundCount, List<Car> cars) {
        this.roundCount = roundCount;
        movingRecords = initMovingRecords(cars);
    }

    private List<MovingRecord> initMovingRecords(List<Car> cars) {
        return cars.stream().map(MovingRecord::new).collect(Collectors.toList());
    }

    public void report(List<Car> cars) {
        for (Car car : cars) {
            MovingRecord movingRecord = findMovingRecord(car.getId());
            movingRecord.addPositionRecord(car.getPosition());
        }
    }

    private MovingRecord findMovingRecord(int carId) {
        return movingRecords.stream()
                .filter(movingRecord -> movingRecord.isSame(carId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 carId입니다."));
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
                .max(Comparator.comparingInt(MovingRecord::getLastPosition))
                .orElseThrow(() -> new NoSuchElementException("값이 없습니다."))
                .getLastPosition();
    }


    public int getRoundCount() {
        return roundCount.getValue();
    }

    public List<MovingRecord> getMovingRecords() {
        return movingRecords;
    }
}
