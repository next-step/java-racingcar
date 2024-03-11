package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("from 메서드에 자연수를 전달하면, 정상적으로 Car 객체가 생성된다.")
    void from_PositiveNumber_NewCar() {
        final int number = 1;
        final Car newCar = Car.from(number);

        assertThat(newCar.number())
                .isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("from 메서드에 0 혹은 음의 정수를 전달하면, IllegalArgumentException을 던진다.")
    void from_NegativeOrZeroNumber_IllegalArgumentException(final int negativeOrZeroNumber) {
        assertThatThrownBy(() -> Car.from(negativeOrZeroNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 번호는 자연수만 가능합니다.");
    }

    @Test
    @DisplayName("move 메서드에 전진 조건에 해당하는 숫자를 전달하면, 자동차가 한 칸 전진한다.")
    void move_ForwardCondition_MovePositionForward() {
        final Car car = Car.from(1);
        final int previousPosition = car.position();
        final int forwardMovingCondition = 4;

        car.moveOrStopByCondition(forwardMovingCondition);

        assertThat(car.position())
                .isEqualTo(previousPosition + 1);
    }

    @Test
    @DisplayName("move 메서드에 정지 조건에 해당하는 숫자를 전달하면, 자동차는 현재 위치를 유지한다.")
    void move_StopCondition_KeepPreviousPosition() {
        final Car car = Car.from(1);
        final int previousPosition = car.position();
        final int stopMovingCondition = 3;

        car.moveOrStopByCondition(stopMovingCondition);

        assertThat(car.position())
                .isEqualTo(previousPosition);
    }
}
