package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.step3.CarRacingTest.TestingCar;

public class RaceRecordTest {
    private RaceRecord raceRecord;
    // TODO 레코드 상태 존재 v
    // TODO 이동 기록 저장 v
    // TODO 가장 많이 이동한 기록 반환 v
    // TODO 기록횟수 반환 v
    // TODO 이름으로 정렬된 기록 반환 v -> 주어진 휫수만큼 이동기록을 제공하는 함수를 실행할 수 있다.

    @BeforeEach
    void setUp() {
        raceRecord = new RaceRecord();
    }

    @Test
    @DisplayName("RaceRecord는 생성후 이동거리는 0이다.")
    void initState() {
        assertThat(raceRecord.getTotalTry()).isEqualTo(0);
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

    @Test
    @DisplayName("RaceRecord는 전체 이동거리를 반환한다.")
    void totalMoves() {
        saveRecords(10, new TestingCar("blue", 2), //
                new TestingCar("red", 3),  //
                new TestingCar("white", 2),  //
                new TestingCar("gray", 3));

        assertThat(raceRecord.getTotalTry()).isEqualTo(10);
    }

    @Test
    @DisplayName("RaceRecord는 모든 자동차의 이동시도 횟수는 동일해야 한다")
    void checkState() {
        TestingCar firstCar = new TestingCar("red", 1);
        firstCar.move();
        raceRecord.saveRecord(firstCar);

        TestingCar secondCar = new TestingCar("blue", 2);
        secondCar.move();
        raceRecord.saveRecord(secondCar);
        secondCar.move();
        raceRecord.saveRecord(secondCar);

        assertThatThrownBy(() -> raceRecord.getTotalTry()) //
                .isInstanceOf(IllegalStateException.class) //
                .hasMessage("모든 자동차의 이동시도횟수 기록은 동일해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("RaceRecord는 주어진 휫수만큼 이동기록을 제공하는 함수를 실행할 수 있다")
    @ValueSource(ints = {1, 2, 3})
    void takeRecordUntil(int tris) {
        saveRecords(5, new TestingCar("blue", 2), //
                new TestingCar("red", 3),  //
                new TestingCar("white", 2),  //
                new TestingCar("gray", 3));

        AtomicInteger assertions = new AtomicInteger();
        raceRecord.forEachRecordUntil(tris, (name, record) -> {
            assertThat(record.size()).isEqualTo(tris);
            assertions.incrementAndGet();
        });
        assertThat(assertions.get()).isEqualTo(4); // consumer 가 자동차수만큼 실행되었는지 검증
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

        public int getTotalTry() {
            if (records.isEmpty()) {
                return 0;
            }

            int totalTry = records.values().iterator().next().size();

            checkAllRecord(totalTry);

            return totalTry;
        }

        public void forEachRecordUntil(int tries, BiConsumer<String, List<Boolean>> biConsumer) {
            records.forEach((name, record) -> biConsumer.accept(name, record.subList(0, tries)));
        }

        private void checkAllRecord(int expectedTry) {
            records.values() //
                    .stream() //
                    .map(List::size) //
                    .forEach(tries -> throwIfNotEqual(expectedTry, tries));
        }

        private void throwIfNotEqual(int expectedTry, int tries) {
            if (expectedTry != tries) {
                throw new IllegalStateException("모든 자동차의 이동시도횟수 기록은 동일해야 합니다.");
            }
        }
    }

}
