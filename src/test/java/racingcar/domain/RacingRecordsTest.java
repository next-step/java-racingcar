package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 기록 테스트")
class RacingRecordsTest {

    MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new RacingMoveStrategy();
    }

    @Test
    @DisplayName("우승자 가져오기")
    void getRacingWinner() {
        // given
        RacingRecords racingRecords = new RacingRecords();

        Car bmwCar = new Car(moveStrategy,"bmw");
        Car audiCar = new Car(moveStrategy,"audi");
        Car benzCar = new Car(moveStrategy, "benz");

        racingRecords.add(new RacingRecord(bmwCar, 10));
        racingRecords.add(new RacingRecord(audiCar, 10));
        racingRecords.add(new RacingRecord(benzCar, 12));

        // when
        List<String> racingWinner = racingRecords.getRacingWinner();

        // then
        assertThat(racingWinner).containsExactly(benzCar.getName());
    }

    @Test
    @DisplayName("레이싱 기록 추가하기")
    void addRacingRecord() {
        RacingRecords racingRecords = new RacingRecords();
        racingRecords.add(new RacingRecord(new Car(moveStrategy), 0));

        assertThat(racingRecords.getRacingRecords().size()).isEqualTo(1);
    }
}