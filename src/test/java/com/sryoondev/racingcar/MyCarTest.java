package com.sryoondev.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyCarTest {
    @Test
    @DisplayName("자동차의 전진 테스트")
    public void testMove() {
        MyCar myCar = new MyCar();
        myCar.move();
        assertThat(myCar.printRoute()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차의 멈춤 테스트")
    void testStop() {
        MyCar myCar = new MyCar();
        myCar.stop();
        assertThat(myCar.printRoute()).isEqualTo("");
    }

    @ParameterizedTest
    @DisplayName("입력 값에 따라 전진하거나 멈추는지 테스트")
    @CsvSource(value = {"8,'-'", "2,''", "4,'-'"})
    void testRace(int randomNumber, String route) {
        MyCar myCar = new MyCar();
        myCar.race(randomNumber);
        assertThat(myCar.printRoute()).isEqualTo(route);
    }
}
