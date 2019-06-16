package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {
    @DisplayName("Car 객체가 잘 생성되는지")
    @Test
    void constructor() {
        final Car car = Car.from(1);
        assertThat(car).isNotNull();
        assertThat(car.getPosition())
                .isEqualTo(1);
    }

    @DisplayName("0보다 작은 position 이면 자동차 객체를 생성할 수 없어야함")
    @Test
    void constructorThrowsException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(-1))
                .withMessageContaining("must be greater than");
    }

    @DisplayName("defaultInstance 로 생성된 자동차의 위치는 0이어야함")
    @Test
    void defaultInstanceFromStaticFactoryMethod() {
        final Car defaultCar = Car.defaultInstance();
        assertThat(defaultCar).isNotNull();
        assertThat(defaultCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차가 주어진 거리만큼 이동이 잘 되는지")
    @Test
    void move() {
        // given
        final Car car = Car.defaultInstance();
        assertThat(car.getPosition()).isEqualTo(0);
        // when
        final Car movedCar = car.move(1);
        // then
        assertThat(movedCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 후 좌표가 0보다 작은 경우 자동차 이동에 실패해야함")
    @Test
    void failToMoveWhenTargetPositionIsLessThanZero() {
        // given
        final Car car = Car.defaultInstance();
        assertThat(car.getPosition()).isEqualTo(0);

        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.move(-1))
                // then
                .withMessageContaining("must be greater than");
    }

    @DisplayName("자동차를 이동시키는 경우 원본객체가 position 값을 잘 유지하는지")
    @Test
    void immutableWhenMove() {
        // given
        final Car car = Car.defaultInstance();
        assertThat(car.getPosition()).isEqualTo(0);
        // when
        final Car movedCar = car.move(1);
        assertThat(movedCar).isNotNull();
        // then
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 이동에 실패한 경우 원본객체가 position 값을 잘 유지하는지")
    @Test
    void immutableWhenFailToMove() {
        // given
        final Car car = Car.defaultInstance();
        assertThat(car.getPosition()).isEqualTo(0);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.move(-1))
                .withMessageContaining("must be greater than");
        // then
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}