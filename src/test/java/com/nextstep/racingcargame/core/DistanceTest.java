package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;

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
        Distance oneStep = new Distance(1);
        Distance zeroStep = new Distance(0);
        assertThat(oneStep.isLongerThan(zeroStep)).isTrue();
    }

    @Test
    @DisplayName("차량 이동거리가 같은 Distance 객체 비교시 참을 리턴한다.")
    void isSameTest() {
        Distance distance_one = new Distance(MOVE_FIVE_STEP);
        Distance distance_two = new Distance(MOVE_FIVE_STEP);
        assertThat(distance_one).isEqualTo(distance_two);
    }

}