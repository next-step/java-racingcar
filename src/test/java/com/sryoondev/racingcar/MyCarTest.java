package com.sryoondev.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
