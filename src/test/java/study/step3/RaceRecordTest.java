package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceRecordTest {
    // TODO 레코드 상태 존재 v
    // TODO 이동 기록 저장
    // TODO 가장 많이 이동한 기록 반환
    // TODO 기록횟수 반환
    // TODO 이름으로 정렬된 기록 반환

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

    private static class RaceRecord {
        public boolean isEmpty() {
            return true;
        }
    }
}
