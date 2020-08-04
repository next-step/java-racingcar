package com.hskim.nextstep.step03.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/*
    com.hskim.nextstep.step03 - RacingCar class 테스트
 */
public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setup() {

        racingCar = new RacingCar(1);
    }

    @DisplayName("moveForward() 메소드 검증")
    @Test
    void moveForwardTest() {

        // 초기화 후 총 이동거리 = 0
        assertThat(racingCar.getTotalMovedDistance()).isEqualTo(0);
        // 3만큼 이동할 수도 안 할수도 있음.
        assertThat(racingCar.moveForward(3)).isIn(0, 3);
    }
}
