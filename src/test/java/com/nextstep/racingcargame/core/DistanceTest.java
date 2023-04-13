package com.nextstep.racingcargame.core;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final int MOVE_FIVE_STEP = 5;

    @Test
    @DisplayName("차량의 이동거리만큼의 길이를 문자열로 정상 출력한다")
    void distanceFormTest() {
        Distance distance = new Distance(MOVE_FIVE_STEP);
        assertThat(distance.distanceForm(CAR_DISTANCE_DISPLAY_UNIT))
                .isEqualTo("-".repeat(MOVE_FIVE_STEP));
    }

    @Test
    @DisplayName("Random 난수 값이 3 이하인 경우 거리가 변경되지 않는다.")
    void stopTest() {
        Distance distance = new Distance(0);
        assertThat(distance.moveForward(3)).isEqualTo(new Distance(0));
    }

    @Test
    @DisplayName("Random 난수 값이 4 이상인경우 앞으로 한칸 웁직인다")
    void moveForwardTest() {
        Distance distance = new Distance(0);
        assertThat(distance.moveForward(4)).isEqualTo(new Distance(1));
    }
}