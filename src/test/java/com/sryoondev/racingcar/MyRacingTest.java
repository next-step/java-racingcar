package com.sryoondev.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyRacingTest {
    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차 수와 시도 횟수 테스트")
    @CsvSource(value = {"3,5", "5,10"})
    public void testCarAndRacingCount(int carCount, int racingCount) {
        MyRacing myRacing = new MyRacing(carCount, racingCount);
        assertThat(myRacing.getCarCount()).isEqualTo(carCount);
        assertThat(myRacing.getRacingCount()).isEqualTo(racingCount);
    }
}
