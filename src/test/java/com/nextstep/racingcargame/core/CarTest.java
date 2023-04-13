package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final String TEST_CAR_NAME = "test";

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final String CAR_NAME_AND_DISTANCE_DELIMITER = " : ";

    private static final int MOVE_THREE_STEP = 3;

    private static final int MOVE_FOUR_STEP = 4;

    @Test
    @DisplayName("출력 폼에 맞춰 차량 이동거리에 대해 아웃풋 값을 정상 리턴한다.")
    void carPrintTest() {
        Car car = new Car(TEST_CAR_NAME, MOVE_THREE_STEP);
        assertThat(car.getDistanceAsPrintForm(CAR_NAME_AND_DISTANCE_DELIMITER
                , CAR_DISTANCE_DISPLAY_UNIT))
                .isEqualTo(TEST_CAR_NAME
                        + CAR_NAME_AND_DISTANCE_DELIMITER
                        + CAR_DISTANCE_DISPLAY_UNIT.repeat(MOVE_THREE_STEP));
    }

    @Test
    @DisplayName("3 칸 이동한 자동차 보다 4칸을 이동한 자동차가 더 멀리간 값을 참으로 출력한다.")
    void isLongerThanTest() {
        Car fourMovedCar = new Car(TEST_CAR_NAME,MOVE_FOUR_STEP);
        Distance moveThreeStep = new Distance(MOVE_THREE_STEP);
        assertThat(fourMovedCar.isLongerThan(moveThreeStep)).isTrue();
    }

    @Test
    @DisplayName("Equals And Hash Code 구현에 따라 Car 객체에 동일한 값이 주입되어 생성된 경우 서로 같은 해시값을 갖는다")
    void equalsAndHashCodeTest() {
        Car group_one = new Car(TEST_CAR_NAME, new Distance(0));
        Car group_two = new Car(TEST_CAR_NAME, new Distance(0));
        assertThat(group_one.equals(group_two)).isTrue();
    }



}
