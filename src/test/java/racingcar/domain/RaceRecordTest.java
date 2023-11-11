package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceRecordTest {
    @Test
    @DisplayName("경기 기록을 생선한다, 자동차 이름, 위치 값을 가진다")
    public void create() {
        RaceRecord raceRecord = new RaceRecord(new CarName("A"), new Position(1));
        assertThat(raceRecord.carName()).isEqualTo(new CarName("A"));
        assertThat(raceRecord.position()).isEqualTo(new Position(1));
    }
}