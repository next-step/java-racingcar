package com.sryoondev.racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyRacingTest {
    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차 수와 시도 횟수 테스트")
    @ValueSource(ints = {3, 5})
    public void testGetCarCount(int carCount) {
        MyRacing myRacing = new MyRacing(carCount);
        assertThat(myRacing.getCarCount()).isEqualTo(carCount);
    }
}
