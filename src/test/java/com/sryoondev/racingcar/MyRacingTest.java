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

    @ParameterizedTest
    @DisplayName("한 번 이동시 주행 결과가 0 ~ 차량 갯수만큼 나오는지 테스트")
    @CsvSource(value = {"3,5", "5,10"})
    public void testRace(int carCount, int racingCount) {
        MyRacing myRacing = new MyRacing(carCount, racingCount);
        String race = myRacing.race();
        assertThat(race.split("-").length).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(carCount);
    }

    @ParameterizedTest
    @DisplayName("한 게임시 결과가 이동 갯수만큼 나오는지 테스트")
    @CsvSource(value = {"3,5", "5,10"})
    public void testStart(int carCount, int racingCount) {
        MyRacing myRacing = new MyRacing(carCount, racingCount);
        String race = myRacing.start();
        assertThat(race.split("\\n\\n").length).isEqualTo(racingCount);
    }
}
