package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest implements PositionHelper {
    private static final CarName CAR_NAME = CarName.from("carName");

    @DisplayName("Car 객체가 잘 생성되는지")
    @Test
    void constructor() {
        final Car car = Car.from(CAR_NAME);
        assertThat(car).isNotNull();
        assertThat(car.getPosition().value())
                .isEqualTo(0);
    }

    @DisplayName("carName 이 null 이면 자동차 객체를 생성할 수 없어야함")
    @Test
    void constructorThrowsExceptionWhenGivenCarNameIsNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(null))
                .withMessageContaining("must not be null");
    }

    @DisplayName("팩터리메서드로 생성된 자동차의 위치는 0이어야함")
    @Test
    void instanceFromStaticFactoryMethodShouldBeLocatedAtOrigin() {
        final Car defaultCar = Car.from(CAR_NAME);
        assertThat(defaultCar).isNotNull();
        assertThat(defaultCar.getPosition().value()).isEqualTo(0);
    }

    @DisplayName("자동차가 주어진 거리만큼 이동이 잘 되는지")
    @Test
    void move() {
        // given
        final Car car = Car.from(CAR_NAME);
        assertThat(car.getPosition().value()).isEqualTo(0);
        // when
        final Car movedCar = car.move(1);
        // then
        assertThat(movedCar.getPosition().value()).isEqualTo(1);
    }

    @DisplayName("이동 후 좌표가 0보다 작은 경우 자동차 이동에 실패해야함")
    @Test
    void failToMoveWhenTargetPositionIsLessThanZero() {
        // given
        final Car car = Car.from(CAR_NAME);
        assertThat(car.getPosition().value()).isEqualTo(0);

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
        final Car car = Car.from(CAR_NAME);
        assertThat(car.getPosition().value()).isEqualTo(0);
        // when
        final Car movedCar = car.move(1);
        assertThat(movedCar).isNotNull();
        // then
        assertThat(car).isNotNull();
        assertThat(car.getPosition().value()).isEqualTo(0);
    }

    @DisplayName("자동차 이동에 실패한 경우 원본객체가 position 값을 잘 유지하는지")
    @Test
    void immutableWhenFailToMove() {
        // given
        final Car car = Car.from(CAR_NAME);
        assertThat(car.getPosition().value()).isEqualTo(0);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.move(-1))
                .withMessageContaining("must be greater than");
        // then
        assertThat(car).isNotNull();
        assertThat(car.getPosition().value()).isEqualTo(0);
    }

    @DisplayName("자동차가 주어진 위치에 있는지 확인할 수 있어야함")
    @Test
    void isLocatedAt() {
        // given
        final Car car = Car.from(CAR_NAME);
        // when
        boolean result = car.isLocatedAt(Position.origin());
        // then
        assertThat(result).isTrue();
    }
}