package com.sryoondev.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @CsvSource(value = {"true,'-'", "false,''"})
    void testRace(boolean movable, String route) {
        MyCar myCar = new MyCar();
        myCar.race(movable);
        assertThat(myCar.printRoute()).isEqualTo(route);
    }

    @ParameterizedTest
    @DisplayName("이동거리 테스트")
    @ValueSource(ints = {3, 10})
    void testGetMoveDistance(int count) {
        MyCar myCar = new MyCar();
        for (int i = 0; i < count; i++) {
            myCar.move();
        }
        assertThat(myCar.getMoveDistance()).isEqualTo(count);
    }
}
