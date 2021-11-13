package com.sryoondev.racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MovableCheckerTest {
    @ParameterizedTest
    @DisplayName("자동차가 전진할 수 있는 숫자값인지 테스트. 4 이상이면 전진")
    @CsvSource(value = {"1,false", "3,false", "4,true", "9,true"})
    public void testIsMovable(int number, boolean isMovable) {
        MovableChecker movableChecker = new MovableChecker();
        assertThat(movableChecker.isMovable(number)).isEqualTo(isMovable);
    }
}