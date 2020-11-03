package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.CarRacingTest.TestingCar;

public class RaceRecordTest {
    private RaceRecord raceRecord;
    // TODO 레코드 상태 존재 v
    // TODO 이동 기록 저장 v
    // TODO 가장 많이 이동한 기록 반환
    // TODO 기록횟수 반환
    // TODO 이름으로 정렬된 기록 반환 v

    @BeforeEach
    void setUp() {
        raceRecord = new RaceRecord();
    }

    @Test
    @DisplayName("RaceRecord는 생성후 비어있는 상태이다.")
    void initState() {
        RaceRecord raceRecord = new RaceRecord();
        assertThat(raceRecord.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("RaceRecord는 자동차 이동기록을 저장할 수 있다.")
    void saveMove() {
        RaceRecord raceRecord = new RaceRecord();

        Car car = new TestingCar();
        raceRecord.saveRecord(car);

        assertThat(raceRecord.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("RaceRecord는 가장 많이 이동한 자동차의 이름을 한대 이상 반환할 수 있다.")
    void mostMovingCarName() {

        saveRecords(5, new TestingCar("blue", 2), //
                new TestingCar("red", 3),  //
                new TestingCar("white", 2),  //
                new TestingCar("gray", 3));

        assertThat(raceRecord.listMostMovingNames()).containsOnly("red", "gray");
    }

    private void saveRecords(int totalMoves, Car... cars) {
        for (int i = 0; i < totalMoves; i++) {
            moveAndSave(cars);
        }
    }

    private void moveAndSave(Car[] cars) {
        for (Car car : cars) {
            car.move();
            raceRecord.saveRecord(car);
        }
    }

    private static class RaceRecord {
        private final Map<String, List<Boolean>> records = new TreeMap<>();

        public boolean isEmpty() {
            return records.isEmpty();
        }

        public void saveRecord(Car car) {
            records.computeIfAbsent(car.getName(), key -> new ArrayList<>()) //
                    .add(car.isMoved());
        }

        public Set<String> listMostMovingNames() {
            int mostMove = getMostMove();
            return records.entrySet() //
                    .stream() //
                    .map(entry -> new SimpleEntry<>(entry.getKey(), countMove(entry.getValue()))) //
                    .filter(entry -> entry.getValue() >= mostMove) //
                    .map(Map.Entry::getKey) //
                    .collect(toSet());
        }

        private int getMostMove() {
            return records.values() //
                    .stream() //
                    .mapToInt(this::countMove) //
                    .max() //
                    .orElse(0);
        }

        private int countMove(List<Boolean> values) {
            return values.stream().mapToInt(moved -> moved ? 1 : 0).sum();
        }
    }

}
