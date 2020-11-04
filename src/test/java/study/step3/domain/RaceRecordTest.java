package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.TestingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceRecordTest {
    private RaceRecord raceRecord;

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
        int totalTry = 5;
        saveRecord(totalTry, 2, new TestingCar("blue"));
        saveRecord(totalTry, 3, new TestingCar("red"));
        saveRecord(totalTry, 2, new TestingCar("white"));
        saveRecord(totalTry, 3, new TestingCar("gray"));

        assertThat(raceRecord.listMostMovingNames()).containsOnly("red", "gray");
    }

    @Test
    @DisplayName("RaceRecord는 전체 이동거리를 반환한다.")
    void totalMoves() {
        int totalTry = 10;
        saveRecord(totalTry, 2, new TestingCar("blue"));
        saveRecord(totalTry, 3, new TestingCar("red"));
        saveRecord(totalTry, 2, new TestingCar("white"));
        saveRecord(totalTry, 3, new TestingCar("gray"));

        assertThat(raceRecord.getTotalTry()).isEqualTo(10);
    }

    @Test
    @DisplayName("RaceRecord는 모든 자동차의 이동시도 횟수는 동일해야 한다")
    void checkState() {
        TestingCar firstCar = new TestingCar("red");
        firstCar.move();
        raceRecord.saveRecord(firstCar);

        TestingCar secondCar = new TestingCar("blue");
        secondCar.move();
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
        int totalTry = 5;
        saveRecord(totalTry, 2, new TestingCar("blue"));
        saveRecord(totalTry, 3, new TestingCar("red"));
        saveRecord(totalTry, 2, new TestingCar("white"));
        saveRecord(totalTry, 3, new TestingCar("gray"));

        int[] assertions = new int[]{0};
        raceRecord.forEachRecordUntil(tris, (name, record) -> {
            assertThat(record.size()).isEqualTo(tris);
            assertions[0]++;
        });
        assertThat(assertions[0]).isEqualTo(4); // consumer 가 자동차수만큼 실행되었는지 검증
    }

    private void saveRecord(int totalTry, int moves, TestingCar car) {
        raceRecord.saveRecord(car);
        for (int i = 0, j = moves; i < totalTry; i++, j--) {
            car.move(j > 0);
        }
    }
}
