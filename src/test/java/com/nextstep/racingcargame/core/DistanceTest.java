package com.nextstep.racingcargame.core;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final int MOVE_FIVE_STEP = 5;

    private static final int STOP_NUMBER = 3;

    private static final int MOVE_NUMBER = 4;

    private static final String TEST_CAR_NAME = "test";


    @Test
    @DisplayName("차량의 이동거리만큼의 길이를 문자열로 정상 출력한다")
    void distanceFormTest() {
        Distance distance = new Distance(MOVE_FIVE_STEP);
        assertThat(CAR_DISTANCE_DISPLAY_UNIT.repeat(distance.distanceIntType()))
                .isEqualTo("-".repeat(MOVE_FIVE_STEP));
    }

    @Test
    @DisplayName("3 칸 이동한 자동차 보다 4칸을 이동한 자동차가 더 멀리간 값을 참으로 출력한다.")
    void isLongerThanTest() {
        Car fourMovedCar = new Car(TEST_CAR_NAME, MOVE_NUMBER);
        Distance moveThreeStep = new Distance(STOP_NUMBER);
        Assertions.assertThat(fourMovedCar.isLongerThan(moveThreeStep)).isTrue();
    }

}