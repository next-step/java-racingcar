package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("이동 시 랜덤한 값이 4 이상인 경우 전진한다.")
    @Test
    void test01() {
        // given
        MoveStrategy moveStrategy = () -> true;
        Car car = new Car(moveStrategy);

        // when
        car.move();

        // then
        assertThat(car.position()).isEqualTo(new Position(1));
    }

    @DisplayName("이동 시 랜덤한 값이 4 미만인 경우 멈춘다.")
    @Test
    void test02() {
        // given
        MoveStrategy moveStrategy = () -> false;
        Car car = new Car(moveStrategy);

        // when
        car.move();

        // then
        assertThat(car.position()).isEqualTo(new Position(0));
    }
}
