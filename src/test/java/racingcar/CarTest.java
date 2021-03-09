package racingcar;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("random 값이 4 이상인 경우 전진한다. 아니면 정지한다.")
    @Test
    void moveOrStay() {
        // given
        Car testCar = new Car();

        // when
        final int random = RandomUtil.getRandomIntBetweenZeroToNine();
        testCar.moveOrStay(random);

        // then
        Condition<Car> moved = new Condition<>(
                car -> (MovingForwardCondition.isSatisfied(random) && car.getPosition() == 1)
                        || car.getPosition() == 0,
                "canMove");
        assertThat(testCar).is(moved);
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 5})
    void getPosition(int moveTimes) {
        // given
        Car testCar = new Car();
        assertThat(testCar.getPosition()).isEqualTo(0);
        int moveValue = 5;
        //when
        for (int i = 0; i < moveTimes; i++) {
            testCar.moveOrStay(moveValue);
        }
        //then
        assertThat(testCar.getPosition()).isEqualTo(moveTimes);
    }
}
