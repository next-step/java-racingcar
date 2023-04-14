package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;

import com.nextstep.racingcargame.util.RandomNumber;
import com.nextstep.racingcargame.util.RandomNumberZeroToNine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final String TEST_CAR_NAME = "test";

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final String CAR_NAME_AND_DISTANCE_DELIMITER = " : ";

    private static final int STOP_NUMBER = 3;

    private static final int MOVE_NUMBER = 4;

    private static final int MOVE_STEP = 1;

    private static final int CAR_START_POSITION_NUMBER = 0;

    @Test
    @DisplayName("출력 폼에 맞춰 차량 이동거리에 대해 아웃풋 값을 정상 리턴한다.")
    void carPrintTest() {
        Car car = new Car(TEST_CAR_NAME, STOP_NUMBER);
        assertThat(car.getDistanceAsPrintForm(CAR_NAME_AND_DISTANCE_DELIMITER
                , CAR_DISTANCE_DISPLAY_UNIT))
                .isEqualTo(TEST_CAR_NAME
                        + CAR_NAME_AND_DISTANCE_DELIMITER
                        + CAR_DISTANCE_DISPLAY_UNIT.repeat(STOP_NUMBER));
    }

    @Test
    @DisplayName("3 칸 이동한 자동차 보다 4칸을 이동한 자동차가 더 멀리간 값을 참으로 출력한다.")
    void isLongerThanTest() {
        Car fourMovedCar = new Car(TEST_CAR_NAME, MOVE_NUMBER);
        Distance moveThreeStep = new Distance(STOP_NUMBER);
        assertThat(fourMovedCar.isLongerThan(moveThreeStep)).isTrue();
    }

    @Test
    @DisplayName("Equals And Hash Code 구현에 따라 Car 객체에 동일한 값이 주입되어 생성된 경우 서로 같은 해시값을 갖는다")
    void equalsAndHashCodeTest() {
        Car group_one = new Car(TEST_CAR_NAME, new Distance(0), new RandomNumberZeroToNine());
        Car group_two = new Car(TEST_CAR_NAME, new Distance(0), new RandomNumberZeroToNine());
        assertThat(group_one.equals(group_two)).isTrue();
    }

    @Test
    @DisplayName("차량 이동거리가 같은 Distance 객체 비교시 참을 리턴한다.")
    void isSameTest() {
        Car car = new Car(TEST_CAR_NAME, new Distance(CAR_START_POSITION_NUMBER),
                new RandomNumberZeroToNine());
        assertThat(car.sameDistance(new Distance(CAR_START_POSITION_NUMBER))).isTrue();
    }

    @Test
    @DisplayName("랜덤으로 발생한 숫자가 3 이하일경우 차량은 정지상태를 유지한다")
    void carStopTest() {
        Car car = new Car(TEST_CAR_NAME, new Distance(CAR_START_POSITION_NUMBER),
                new CarStopNumber());
        car = car.moveForwardByNumber();
        assertThat(car).isEqualTo(new Car(TEST_CAR_NAME, new Distance(CAR_START_POSITION_NUMBER),
                new CarStopNumber()));
    }

    @Test
    @DisplayName("랜덤으로 발생한 숫자가 4 이상일 경우 차량은 한칸 앞으로 움직인다.")
    void moveTest() {
        Car car = new Car(TEST_CAR_NAME, new Distance(CAR_START_POSITION_NUMBER),
                new CarForceMoveNumber());
        car = car.moveForwardByNumber();
        assertThat(car).isEqualTo(new Car(TEST_CAR_NAME, new Distance(MOVE_STEP),
                new CarForceMoveNumber()));
    }

    private static class CarForceMoveNumber implements RandomNumber {

        @Override
        public int randomNumber() {
            return MOVE_NUMBER;
        }
    }

    private static class CarStopNumber implements RandomNumber {

        @Override
        public int randomNumber() {
            return STOP_NUMBER;
        }
    }
}
