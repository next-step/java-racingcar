package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingResultTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0:0", "0:1:0", "0:2:1", "1:0:1", "1:1:2", "1:2:3"}, delimiter = ':')
    @DisplayName("레이싱 결과 값 조회 테스트")
    void invalidCarCount(int carIndex, int tryIndex, int value) {
        final CarRecordHistory carRecordHistory0 = new CarRecordHistory();
        carRecordHistory0.stop();
        carRecordHistory0.stop();
        carRecordHistory0.go();

        final CarRecordHistory carRecordHistory1 = new CarRecordHistory();
        carRecordHistory1.go();
        carRecordHistory1.go();
        carRecordHistory1.go();

        RacingResult racingResult = new RacingResult();
        racingResult.addRecord(carRecordHistory0);
        racingResult.addRecord(carRecordHistory1);
        assertThat(racingResult.recordPosition(carIndex, tryIndex))
            .isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:0", "0:-2", "0:3", "0:7"}, delimiter = ':')
    @DisplayName("인덱스 범위를 벗어나는 값 호출 테스트")
    void outOfIndexTest(int carIndex, int tryIndex) {
        final CarRecordHistory carRecordHistory0 = new CarRecordHistory();
        carRecordHistory0.stop();
        carRecordHistory0.stop();
        carRecordHistory0.go();

        RacingResult racingResult = new RacingResult();
        racingResult.addRecord(carRecordHistory0);

        assertThatThrownBy(()->racingResult.recordPosition(carIndex, tryIndex)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
